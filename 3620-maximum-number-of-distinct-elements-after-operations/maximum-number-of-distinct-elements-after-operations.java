class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int curr = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            int left = num - k;
            int right = num + k;

            if (curr < left) {
                curr = left;
            }
            if (curr <= right) {
                count++;
                curr++;
            }
        }
        return count;
    }
}
