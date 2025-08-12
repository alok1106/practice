class Solution {
    public int numberOfWays(int n, int x) {
        int modulo = 1_000_000_007;
        int dp[]= new int[n+1];
        List<Integer> powers = new ArrayList<>();
        for(int i = 1; ; i++){
            long p = (long)Math.pow(i, x);
            if(p > n){
                break;
            }
            powers.add((int)p);//precompute powers of number with x
        }
        dp[0] = 1; //one way to get sum = 0

        for(int p : powers){
            for(int j = n; j >= p; j--){
                //number of way for sum = j is either include sum of p or without p
                dp[j] = (dp[j] + dp[j - p]) % modulo; 
            }
        }
        return dp[n];
    }
}