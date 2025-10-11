import java.util.*;

public class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) freq.merge(p, 1L, Long::sum);

        int k = freq.size();
        if (k == 0) return 0L;

        int[] keys = new int[k];
        int idx = 0;
        for (int key : freq.keySet()) keys[idx++] = key;
        Arrays.sort(keys);

        long[] dp = new long[k];
        dp[0] = (long) keys[0] * freq.get(keys[0]);

        for (int i = 1; i < k; ++i) {
            long damage = (long) keys[i] * freq.get(keys[i]);

            int target = keys[i] - 3;
            int pos = Arrays.binarySearch(keys, 0, i, target);
            int j = (pos >= 0) ? pos : -pos - 2;

            long take = damage + (j >= 0 ? dp[j] : 0L);
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[k - 1];
    }
}
