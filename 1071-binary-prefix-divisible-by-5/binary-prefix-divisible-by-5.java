class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int decimalRemainder = 0;
        for(int i = 0; i<nums.length; i++){
            decimalRemainder = (decimalRemainder * 2 + nums[i]) % 5;
            result.add(decimalRemainder == 0);
        }
        return result;
    }
}