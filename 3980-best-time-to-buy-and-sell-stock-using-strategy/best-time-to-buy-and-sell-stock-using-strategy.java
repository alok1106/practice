class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long baseProfit = 0;
        long[] prefOrig = new long[n + 1];
        long[] prefPrice = new long[n + 1];

        for (int i = 0; i < n; i++) {
            long orig = (long) strategy[i] * prices[i];
            baseProfit += orig;

            prefOrig[i + 1] = prefOrig[i] + orig;
            prefPrice[i + 1] = prefPrice[i] + prices[i];
        }

        long maxGain = 0;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long sumOriginal = prefOrig[r] - prefOrig[l];
            long sumSell = prefPrice[r] - prefPrice[mid];

            long gain = sumSell - sumOriginal;
            maxGain = Math.max(maxGain, gain);
        }

        return baseProfit + maxGain;
    }
}
