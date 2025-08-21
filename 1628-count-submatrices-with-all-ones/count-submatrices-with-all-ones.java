class Solution {
    public int numSubmat(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int totalCount = 0;
        
        int[] heights = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            for (int j = 0; j < cols; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = j; k >= 0; k--) {
                    minHeight = Math.min(minHeight, heights[k]);
                    if (minHeight == 0) {
                        break;
                    }
                    totalCount += minHeight;
                }
            }
        }

        return totalCount;
    }
}