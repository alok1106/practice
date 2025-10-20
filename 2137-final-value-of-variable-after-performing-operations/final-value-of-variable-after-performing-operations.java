class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int finalValue = 0;
        for(int i = 0; i < operations.length; i++){
            if(operations[i].contains("+")){
                finalValue++;
            } else {
                finalValue--;
            }
        }
        return finalValue;
    }
}