class Solution {
    public int totalMoney(int n) {
        int week = 0;
        int totalMoney = 0;
        while(n > 0){
            for(int i = week + 1; i <= week + 7; i++){
                totalMoney += i;
                n--;
                if(n < 1){
                    return totalMoney;
                }
            }
            week++;
        }
        return 0;
    }
}