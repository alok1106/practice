class Solution {
    public String largestGoodInteger(String num) {
        String result = "";

        for(int i = 0; i<num.length() - 2; i++){
            char current = num.charAt(i);

            if(current == num.charAt(i+1) && current == num.charAt(i+2)){
                String currentGoodNum = "" + current + current + current;
                
                if(result.isEmpty() || currentGoodNum.compareTo(result) > 0){
                result = currentGoodNum;
                }
            }
        }
        return result;
    }
}