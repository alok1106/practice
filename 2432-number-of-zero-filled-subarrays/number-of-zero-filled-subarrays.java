class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long consecutiveZeroes = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                consecutiveZeroes++;
            } else {
                count += (consecutiveZeroes * (consecutiveZeroes + 1)) / 2;
                consecutiveZeroes = 0;
            }
        }
        count += (consecutiveZeroes * (consecutiveZeroes + 1)) / 2;

        return count;
    }
}