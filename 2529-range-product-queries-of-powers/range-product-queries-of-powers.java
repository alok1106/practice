class Solution {
    public int[] productQueries(int n, int[][] queries) {
        long modulo = 1000000007;
        List<Long> powers = new ArrayList<>();
        long currentPowerOf2 = 1;
        while( n > 0){
            if ((n & 1) == 1){
                powers.add(currentPowerOf2);
            }
            n >>=1;
            currentPowerOf2 <<= 1;
        }
        int[] answers = new int[queries.length];
        for(int i = 0; i < queries.length; i++ ){
            int left = queries[i][0];
            int right = queries[i][1];

            long product = 1;
            for(int j = left; j<=right; j++){
                product = (product * powers.get(j)) % modulo;
            }
            answers[i] = (int) product;
        }
        return answers;
    }
}