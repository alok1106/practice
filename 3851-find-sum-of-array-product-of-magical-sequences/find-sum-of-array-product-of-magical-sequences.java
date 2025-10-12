public class Solution {
    static final long MOD = 1_000_000_007L;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        long[] fact = new long[m + 1], invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[m] = modPow(fact[m], MOD - 2);
        for (int i = m - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        long[][] pow = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            pow[i][0] = 1;
            for (int c = 1; c <= m; c++) pow[i][c] = pow[i][c - 1] * (nums[i] % MOD) % MOD;
        }

        int maxCarry = m;
        long[][][] dp = new long[maxCarry + 1][m + 1][m + 1];
        dp[0][0][0] = 1L;

        for (int pos = 0; pos < n; pos++) {
            long[][][] next = new long[maxCarry + 1][m + 1][m + 1];
            for (int carry = 0; carry <= maxCarry; carry++) {
                for (int used = 0; used <= m; used++) {
                    for (int ones = 0; ones <= m; ones++) {
                        long val = dp[carry][used][ones];
                        if (val == 0) continue;
                        int limit = m - used;
                        for (int cnt = 0; cnt <= limit; cnt++) {
                            int total = cnt + carry;
                            int bit = total & 1;
                            int newOnes = ones + bit;
                            int newCarry = total >>> 1;
                            if (newOnes > m || newCarry > maxCarry) continue;

                            long mul = pow[pos][cnt] * invFact[cnt] % MOD; 
                            long add = val * mul % MOD;
                            int newUsed = used + cnt;
                            next[newCarry][newUsed][newOnes] = (next[newCarry][newUsed][newOnes] + add) % MOD;
                        }
                    }
                }
            }
            dp = next;
        }

        
        long ans = 0;
        for (int carry = 0; carry <= maxCarry; carry++) {
            int carryOnes = Integer.bitCount(carry);
            for (int used = 0; used <= m; used++) {
                if (used != m) continue;
                for (int ones = 0; ones <= m; ones++) {
                    long val = dp[carry][used][ones];
                    if (val == 0) continue;
                    int finalOnes = ones + carryOnes;
                    if (finalOnes == k) {
                        long contrib = val * fact[m] % MOD;
                        ans = (ans + contrib) % MOD;
                    }
                }
            }
        }
        return (int) ans;
    }

    private static long modPow(long a, long e) {
        long r = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }
}
