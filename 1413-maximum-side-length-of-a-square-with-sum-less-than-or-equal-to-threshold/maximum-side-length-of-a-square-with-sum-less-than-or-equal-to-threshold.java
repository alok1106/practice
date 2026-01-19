class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] pref = new int[m + 1][n + 1];

        // Build prefix sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                           + pref[i - 1][j]
                           + pref[i][j - 1]
                           - pref[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n), ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (existsSquare(pref, m, n, mid, threshold)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean existsSquare(int[][] pref, int m, int n,
                                 int size, int threshold) {

        for (int i = size; i <= m; i++) {
            for (int j = size; j <= n; j++) {
                int sum = pref[i][j]
                        - pref[i - size][j]
                        - pref[i][j - size]
                        + pref[i - size][j - size];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
