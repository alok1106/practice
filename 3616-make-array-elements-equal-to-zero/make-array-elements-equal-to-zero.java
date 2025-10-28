class Solution {
  public int countValidSelections(int[] nums) {
    int ans = 0;
    int prefix = 0;
    int suffix = Arrays.stream(nums).sum();

    for (int i = 0; i < nums.length; ++i) {
      suffix -= nums[i];
      prefix += nums[i];
      if (nums[i] > 0)
        continue;
      if (prefix == suffix)
        ans += 2;
      if (Math.abs(prefix - suffix) == 1)
        ans += 1;
    }

    return ans;
  }
}