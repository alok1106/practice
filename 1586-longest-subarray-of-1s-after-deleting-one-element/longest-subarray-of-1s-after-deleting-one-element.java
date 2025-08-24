class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int zerosCount = 0;
        int left = 0;

        // Use a sliding window to find the longest subarray with at most one zero.
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zerosCount++;
            }

            // If we have more than one zero, shrink the window from the left.
            while (zerosCount > 1) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}