class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;

        // suffixMax[i] = max value from i to end
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int value = events[i][2];
            ans = Math.max(ans, value); // take only one event

            int nextIdx = findNext(events, events[i][1] + 1);
            if (nextIdx < n) {
                ans = Math.max(ans, value + suffixMax[nextIdx]);
            }
        }

        return ans;
    }

    // First event with start >= target
    private int findNext(int[][] events, int target) {
        int l = 0, r = events.length - 1;
        int res = events.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
