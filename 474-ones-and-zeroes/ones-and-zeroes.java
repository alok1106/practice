class Solution {
    Integer[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new Integer[strs.length][m+1][n+1];
        return dfs(strs, 0, m, n);
    }

    private int dfs(String[] strs, int index, int m, int n){
        if(index == strs.length){
            return 0;
        }

        if(memo[index][m][n] != null){
            return memo[index][m][n];
        }

        int[] count = countZeroOne(strs[index]);
        int zero = count[0], one = count[1];

        int skip = dfs(strs, index + 1, m, n);

        int take = 0;
        if (zero <= m && one <= n){
            take = 1 + dfs(strs, index + 1, m - zero, n - one);
        }

        return memo[index][m][n] = Math.max(skip, take);
    }

    private int[] countZeroOne(String s){
        int zero = 0, one = 0;
        for (char c : s.toCharArray()){
            if ( c == '0') zero++;
            else one++;
        }
        return new int[]{zero, one};
    }
}