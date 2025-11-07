import java.util.Arrays;

public final class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long K = k;

        // Build prefix sum to compute initial power per city
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; ++i) pref[i + 1] = pref[i] + stations[i];

        long[] initialPower = new long[n];
        long total = 0;
        long minPower = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            initialPower[i] = pref[R + 1] - pref[L];
            total += stations[i];
            minPower = Math.min(minPower, initialPower[i]);
        }

        long left = minPower;                     // lower bound: minimum existing city power
        long right = total + K + 1;               // upper bound: sum + k + 1 (exclusive)

        while (left < right) {
            long mid = (left + right) >>> 1;
            if (check(stations, r, K, mid)) left = mid + 1;
            else right = mid;
        }
        return left - 1;
    }

    // Returns true if every city can have at least `minPower` after using <= additionalStations
    private static boolean check(int[] stations, int r, long additionalStations, long minPower) {
        final int n = stations.length;
        // work with long[] because we will increment values beyond int range
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i) arr[i] = stations[i];

        long power = 0;
        // initialize power with sum of stations[0..r-1] (so when i=0 we add arr[r] below to get 0..r)
        for (int i = 0; i < Math.min(r, n); ++i) power += arr[i];

        for (int i = 0; i < n; ++i) {
            if (i + r < n) power += arr[i + r]; // power = sum(arr[i-r .. i+r])

            if (power < minPower) {
                long need = minPower - power;
                if (need > additionalStations) return false;
                additionalStations -= need;
                int place = Math.min(n - 1, i + r); // place at farthest right to cover many cities
                arr[place] += need;
                power += need;
            }

            if (i - r >= 0) power -= arr[i - r]; // slide window
        }
        return true;
    }
}
