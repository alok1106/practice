class Solution {
    public long minOperations(int[][] queries) {
        long totalOperations = 0;
        for (int[] query : queries) {
            long start = query[0];
            long end = query[1];
            
            long rangeStepsSum = prefixSum(end) - prefixSum(start - 1);
            
            totalOperations += (rangeStepsSum + 1) / 2;
        }
        return totalOperations;
    }

    private long prefixSum(long limit) {
        if (limit <= 0) {
            return 0;
        }
        
        long totalSteps = 0;
        long currentPower = 1;
        int powerLevel = 0;
        
        while (currentPower <= limit) {
            long nextPower = currentPower * 4;
            long upperBound = Math.min(limit, nextPower - 1);
            
            long countAtLevel = upperBound - currentPower + 1;
            
            totalSteps += countAtLevel * (powerLevel + 1);
            
            currentPower = nextPower;
            powerLevel++;
        }
        
        return totalSteps;
    }
}
