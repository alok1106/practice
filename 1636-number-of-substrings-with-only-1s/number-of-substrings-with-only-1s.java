class Solution {
    public int numSub(String s) {
        long count = 0, sum = 0;
        long MOD = 1000000007;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                count++;
            } else {
                sum = (sum + (count * (count + 1) / 2)) % MOD;
                count = 0;
            }
        }
        sum = (sum + (count * (count + 1) / 2)) % MOD;
        return (int) sum;
    }
}