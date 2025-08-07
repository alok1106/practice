class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length; 
        int diagonalFruits = 0; 

        for (int i = 0; i < n; ++i) {
            diagonalFruits += fruits[i][i]; 
        }

        int[][] dp = new int[n][n]; 

        dp[0][n - 1] = fruits[0][n - 1];
        dp[n - 1][0] = fruits[n - 1][0]; 

        for (int k = 1; k < n; ++k) {
            for (int j = n - 1; j >= Math.max(n - 1 - k, k); --j) {
                int i = k;
                int maxPrevFruits = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                if (j < n - 1) {
                    maxPrevFruits = Math.max(maxPrevFruits, dp[i - 1][j + 1]);
                }
                dp[i][j] = maxPrevFruits + fruits[i][j]; 
            }

            for (int i = n - 1; i >= Math.max(n - 1 - k, k); --i) {
                int j = k;
                int maxPrevFruits = Math.max(dp[i][j - 1], dp[i - 1][j - 1]);
                if (i < n - 1) {
                    maxPrevFruits = Math.max(maxPrevFruits, dp[i + 1][j - 1]);
                }
                dp[i][j] = maxPrevFruits + fruits[i][j]; 
            }
        }
        
        return diagonalFruits + dp[n - 1][n - 2] + dp[n - 2][n - 1]; 
    }
}