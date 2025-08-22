class Solution {
    public int minimumArea(int[][] grid) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        boolean oneFound = false;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    oneFound = true;
                    maxRow = Math.max(maxRow, i);
                    minRow = Math.min(minRow, i);
                    maxCol = Math.max(maxCol, j);
                    minCol = Math.min(minCol, j);
                }
            }
        }

        if(!oneFound) return 0;

        int length = maxRow - minRow + 1;
        int breadth = maxCol - minCol + 1;

        return length * breadth;
    }
}