class Solution {
    // Area of the tightest bounding box of 1s inside [r1..r2] x [c1..c2]; 0 if none.
    private int getArea(int[][] grid, int r1, int c1, int r2, int c2) {
        int rows = grid.length, cols = grid[0].length;
        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }
        if (maxRow == -1) return 0; // no 1s in this submatrix
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public int minimumSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int ans = getArea(grid, 0, 0, rows - 1, cols - 1); // baseline (other 2 rects empty)

        // Case 1: three horizontal strips (choose two horizontal cuts)
        for (int r1 = 0; r1 < rows - 2; r1++) {
            for (int r2 = r1 + 1; r2 < rows - 1; r2++) {
                int a1 = getArea(grid, 0,          0, r1,          cols - 1);
                int a2 = getArea(grid, r1 + 1,     0, r2,          cols - 1);
                int a3 = getArea(grid, r2 + 1,     0, rows - 1,    cols - 1);
                ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        // Case 2: three vertical strips (choose two vertical cuts)
        for (int c1 = 0; c1 < cols - 2; c1++) {
            for (int c2 = c1 + 1; c2 < cols - 1; c2++) {
                int a1 = getArea(grid, 0, 0,          rows - 1, c1);
                int a2 = getArea(grid, 0, c1 + 1,     rows - 1, c2);
                int a3 = getArea(grid, 0, c2 + 1,     rows - 1, cols - 1);
                ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        // Case 3: one vertical cut; split one side horizontally (both sides tried)
        for (int c = 0; c < cols - 1; c++) {
            int leftArea  = getArea(grid, 0, 0,          rows - 1, c);
            int rightArea = getArea(grid, 0, c + 1,      rows - 1, cols - 1);

            // Split the right side horizontally into two
            for (int r = 0; r < rows - 1; r++) {
                int rightTop    = getArea(grid, 0,      c + 1, r,        cols - 1);
                int rightBottom = getArea(grid, r + 1,  c + 1, rows - 1, cols - 1);
                ans = Math.min(ans, leftArea + rightTop + rightBottom);
            }

            // Split the left side horizontally into two
            for (int r = 0; r < rows - 1; r++) {
                int leftTop    = getArea(grid, 0,      0, r,        c);
                int leftBottom = getArea(grid, r + 1,  0, rows - 1, c);
                ans = Math.min(ans, leftTop + leftBottom + rightArea);
            }
        }

        // Case 4: one horizontal cut; split one side vertically (both sides tried)
        for (int r = 0; r < rows - 1; r++) {
            int topArea    = getArea(grid, 0,      0, r,        cols - 1);
            int bottomArea = getArea(grid, r + 1,  0, rows - 1, cols - 1);

            // Split the bottom side vertically into two
            for (int c = 0; c < cols - 1; c++) {
                int bottomLeft  = getArea(grid, r + 1, 0,        rows - 1, c);
                int bottomRight = getArea(grid, r + 1, c + 1,    rows - 1, cols - 1);
                ans = Math.min(ans, topArea + bottomLeft + bottomRight);
            }

            // Split the top side vertically into two
            for (int c = 0; c < cols - 1; c++) {
                int topLeft  = getArea(grid, 0, 0,     r,        c);
                int topRight = getArea(grid, 0, c + 1, r,        cols - 1);
                ans = Math.min(ans, topLeft + topRight + bottomArea);
            }
        }

        return ans;
    }
}