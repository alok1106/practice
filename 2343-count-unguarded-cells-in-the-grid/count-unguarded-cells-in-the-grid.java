class Solution {

    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];

        for(int[] w : walls) matrix[w[0]][w[1]] = 1;
        
        for(int[] g: guards) matrix[g[0]][g[1]] = 2;

        for(int[] g : guards) {
            int r = g[0], c = g[1];
            for(int[] d : DIRS) {
                int x = r + d[0], y = c + d[1];
                while(x>= 0 && x < m && y>= 0 && y < n && matrix[x][y] != 1 && matrix[x][y] != 2) {
                    if(matrix[x][y] == 0)
                        matrix[x][y] = 3;
                    x += d[0];
                    y += d[1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(matrix[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }
}