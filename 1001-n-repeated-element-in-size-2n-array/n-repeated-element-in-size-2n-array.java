class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(numMap.containsKey(nums[i])){
                return nums[i];
            } else {
                numMap.put(nums[i],1);
            }
        }
        return 0;
    }
}