class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {
            if (right > 0 && prices[right - 1] - prices[right] != 1) {
                left = right;
            }
            ans += (right - left + 1);
        }

        return ans;
    }
}
