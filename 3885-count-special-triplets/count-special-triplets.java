class Solution {
    public int specialTriplets(int[] nums) {
        final long MOD = 1_000_000_007;

        Map<Integer, Long> rightFreq = new HashMap<>();
        Map<Integer, Long> leftFreq = new HashMap<>();

        for (int x : nums) rightFreq.put(x, rightFreq.getOrDefault(x, 0L) + 1);

        long ans = 0;

        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];
            int target = mid * 2;

            // Remove current from right side
            rightFreq.put(mid, rightFreq.get(mid) - 1);

            long leftCount = leftFreq.getOrDefault(target, 0L);
            long rightCount = rightFreq.getOrDefault(target, 0L);

            ans = (ans + (leftCount * rightCount) % MOD) % MOD;

            // Add current to left side
            leftFreq.put(mid, leftFreq.getOrDefault(mid, 0L) + 1);
        }

        return (int)(ans % MOD);
    }
}
