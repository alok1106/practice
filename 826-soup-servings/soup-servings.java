class Solution {
    public double soupServings(int n) {

        if (n > 4800){
            return 1;
        }

        int scaledN = (n + 24) / 25;
        double [][] memo = new double[scaledN+1][scaledN+1];
        for(double[] row : memo){
            Arrays.fill(row, -1.0);
        }

        return dp(scaledN, scaledN, memo);
    }

    private static double dp(int a, int b, double[][] memo){
        if (a <= 0 && b <= 0){
            return 0.5;
        }

        if (a <= 0){
            return 1.0;
        }

        if (b <= 0){
            return 0.0;
        }

        if(memo[a][b] != -1){
            return memo[a][b];
        }

        double res = 0.25 * (
            dp(a-4, b, memo) +
            dp(a-3, b-1, memo) +
            dp(a-2, b-2, memo) +
            dp(a-1, b-3, memo)
        );

        memo[a][b] = res;
        return res;
    }
}