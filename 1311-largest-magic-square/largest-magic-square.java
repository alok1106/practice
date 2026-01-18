class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 1];

        // Prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        // Try sizes from large to small
        for (int size = Math.min(m, n); size >= 2; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {
                    if (isMagic(i, j, size, row, col, diag1, diag2)) {
                        return size;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isMagic(int r, int c, int k,
                            int[][] row, int[][] col,
                            int[][] d1, int[][] d2) {

        int target = row[r][c + k] - row[r][c];

        // rows
        for (int i = 0; i < k; i++) {
            if (row[r + i][c + k] - row[r + i][c] != target)
                return false;
        }

        // columns
        for (int j = 0; j < k; j++) {
            if (col[r + k][c + j] - col[r][c + j] != target)
                return false;
        }

        // diagonals
        if (d1[r + k][c + k] - d1[r][c] != target)
            return false;

        if (d2[r + k][c] - d2[r][c + k] != target)
            return false;

        return true;
    }
}
