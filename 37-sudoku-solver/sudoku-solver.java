class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    boxes[boxIndex][digit] = true;
                }
            }
        }
        solve(board, rows, cols, boxes);
    }

    private boolean solve(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        int digit = c - '1';
                        int boxIndex = (i / 3) * 3 + (j / 3);
                        if (!rows[i][digit] && !cols[j][digit] && !boxes[boxIndex][digit]) {
                            board[i][j] = c;
                            rows[i][digit] = true;
                            cols[j][digit] = true;
                            boxes[boxIndex][digit] = true;
                            if (solve(board, rows, cols, boxes)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                                rows[i][digit] = false;
                                cols[j][digit] = false;
                                boxes[boxIndex][digit] = false;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}