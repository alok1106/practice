class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];
        int row = 0;
        int col = 0;
        boolean isUp = true;

        for (int i = 0; i < rows * cols; i++) {
            result[i] = mat[row][col];

            if (isUp) {
                row--;
                col++;

                if (row < 0 || col >= cols) {
                    isUp = false;
                    if (col >= cols) {
                        row += 2;
                        col--;
                    } else {
                        row = 0;
                    }
                }
            } else {
                row++;
                col--;

                if (row >= rows || col < 0) {
                    isUp = true;
                    if (row >= rows) {
                        row--;
                        col += 2;
                    } else {
                        col = 0;
                    }
                }
            }
        }

        return result;
    }
}