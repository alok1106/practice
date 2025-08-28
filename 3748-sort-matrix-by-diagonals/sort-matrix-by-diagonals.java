import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;

        for (int row = 0; row < rows; row++) {
            sortDiagonal(mat, row, 0, false);
        }

        for (int col = 1; col < cols; col++) {
            sortDiagonal(mat, 0, col, true);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col, boolean increasing) {
        int rows = mat.length, cols = mat[0].length;
        List<Integer> diagonal = new ArrayList<>();

        int r = row, c = col;
        while (r < rows && c < cols) {
            diagonal.add(mat[r][c]);
            r++;
            c++;
        }

        diagonal.sort(increasing ? Comparator.naturalOrder() : Comparator.reverseOrder());

        r = row; c = col;
        int idx = 0;
        while (r < rows && c < cols) {
            mat[r][c] = diagonal.get(idx++);
            r++;
            c++;
        }
    }
}
