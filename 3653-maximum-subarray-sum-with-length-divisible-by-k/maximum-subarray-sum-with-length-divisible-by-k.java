class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[] best = new long[k];
        Arrays.fill(best, Long.MAX_VALUE);

        long result = Long.MIN_VALUE;

        for (int r = 0; r <= n; r++) {
            int mod = r % k;

            if (best[mod] != Long.MAX_VALUE) {
                result = Math.max(result, prefix[r] - best[mod]);
            }

            best[mod] = Math.min(best[mod], prefix[r]);
        }

        return result;
    }
}
