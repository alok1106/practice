class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sumAbs = 0;
        int minAbs = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negativeCount++;
                int absVal = Math.abs(val);
                sumAbs += absVal;
                minAbs = Math.min(minAbs, absVal);
            }
        }

        if (negativeCount % 2 == 0) {
            return sumAbs;
        } else {
            return sumAbs - 2L * minAbs;
        }
    }
}
