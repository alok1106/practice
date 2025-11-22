class Solution {
    public int minimumOperations(int[] nums) {
        int operation = 0;
        for(int num : nums){
            operation += Math.min(num % 3, 3- num % 3);
        }
        return operation;
    }
}