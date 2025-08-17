class Solution {
    public double new21Game(int n, int k, int maxPts) {

        if ( k == 0 || n >= k + maxPts - 1) return 1.0;

        double[] dp = new double[n+1];
        dp[0] = 1.0;

        double windowSum = 1.0;
        double ans = 0.0;

        for(int i = 1; i <= n; i++){

            dp[i] = windowSum / maxPts;

            if(i < k){                  //score less than k, keep drawing
                windowSum += dp[i];
            } else {                    //score is between k and n, add in answer
                ans += dp[i];
            }

            if(i >= maxPts){
                windowSum -= dp[i - maxPts];
            }
        }

        return ans;
    }
}