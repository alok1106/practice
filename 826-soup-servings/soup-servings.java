class Solution {
    private double[][] memo;
    public double soupServings(int n) {
        //for very large n, probability approaches 1
        if (n > 4800) return 1.0;

        int scaledN = (n + 24) / 25;
        memo = new double[scaledN+1][scaledN+1];
        for(double[] row : memo){
            Arrays.fill(row, -1.0);
        }

        return dp(scaledN, scaledN);
    }

    private double dp(int a, int b){
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if(memo[a][b] != -1) return memo[a][b];
        
        memo[a][b] = 0.25 * (
            dp(a-4, b) +      //100,0 -> 4 parts A, 0 parts B -> division by 25
            dp(a-3, b-1) +    //75,25
            dp(a-2, b-2) +    //50,50
            dp(a-1, b-3)      //25,75
        );

        return memo[a][b];
    }
}