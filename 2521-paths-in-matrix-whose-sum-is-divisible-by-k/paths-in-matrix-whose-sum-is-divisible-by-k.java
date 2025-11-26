class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prev = new int[n][k];
        int[][] curr = new int[n][k];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                Arrays.fill(curr[j], 0);

                int cell = grid[i][j];

                if (i == 0 && j == 0) {
                    curr[0][cell % k] = 1;
                    continue;
                }

                if (j > 0) {
                    for (int r = 0; r < k; r++) {
                        int newR = (r + cell) % k;
                        curr[j][newR] = (curr[j][newR] + curr[j - 1][r]) % MOD;
                    }
                }

                if (i > 0) {
                    for (int r = 0; r < k; r++) {
                        int newR = (r + cell) % k;
                        curr[j][newR] = (curr[j][newR] + prev[j][r]) % MOD;
                    }
                }
            }

            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n - 1][0];
    }
}
