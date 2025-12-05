class Solution {
    public int countPartitions(int[] nums) {
        long total = 0;
        for (int x : nums) total += x;

        if ((total & 1) == 1) return 0;   // total odd -> none
        return nums.length - 1;           // total even -> all n-1 splits
    }
}
