class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cell = board[i][j];

                if (cell == '.') {
                    continue;
                }

                int digit = cell - '1';

                if (rows[i][digit]) {
                    return false;
                }
                rows[i][digit] = true;

                if (cols[j][digit]) {
                    return false;
                }
                cols[j][digit] = true;

                int boxIndex = (i / 3) * 3 + (j / 3);

                if (boxes[boxIndex][digit]) {
                    return false;
                }
                boxes[boxIndex][digit] = true;
            }
        }

        return true;
    }
}