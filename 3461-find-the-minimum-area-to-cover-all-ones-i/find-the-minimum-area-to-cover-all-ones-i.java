class Solution {
    public int minimumArea(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int minRow = row;
        int maxRow = -1;
        int minCol = col;
        int maxCol = -1;


        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    maxRow = Math.max(maxRow, i);
                    minRow = Math.min(minRow, i);
                    maxCol = Math.max(maxCol, j);
                    minCol = Math.min(minCol, j);
                }
            }
        }

        if(maxRow == -1) return 0;

        int length = maxRow - minRow + 1;
        int breadth = maxCol - minCol + 1;

        return length * breadth;
    }
}