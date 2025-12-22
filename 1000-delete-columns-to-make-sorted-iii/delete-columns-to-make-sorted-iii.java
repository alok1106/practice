class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < j; i++) {

                boolean ok = true;
                for (int r = 0; r < n; r++) {
                    if (strs[r].charAt(i) > strs[r].charAt(j)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int maxKept = 0;
        for (int x : dp) maxKept = Math.max(maxKept, x);

        return m - maxKept;
    }
}