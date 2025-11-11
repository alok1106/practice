class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int[] count = countZeroOne(s);
            int zero = count[0], one = count[1];

            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        1 + dp[i - zero][j - one]
                    );
                }
            }
        }

        return dp[m][n];
    }

    private int[] countZeroOne(String s) {
        int zero = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zero++;
            else one++;
        }
        return new int[]{zero, one};
    }
}
