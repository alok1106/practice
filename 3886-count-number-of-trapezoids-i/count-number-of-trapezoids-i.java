class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        long sumPairs = 0;
        long sumSquares = 0;

        for (int count : map.values()) {
            if (count >= 2) {
                long pairs = (long)count * (count - 1) / 2;
                pairs %= MOD;

                sumPairs = (sumPairs + pairs) % MOD;
                sumSquares = (sumSquares + (pairs * pairs) % MOD) % MOD;
            }
        }

        long total = (sumPairs * sumPairs) % MOD;
        total = (total - sumSquares + MOD) % MOD; 
        total = (total * inv2()) % MOD;

        return (int) total;
    }

    private long inv2() {
        return (MOD + 1) / 2;
    }
}
