class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;   // maximum possible T

        while (left < right) {
            long mid = (left + right + 1) / 2;

            if (canRun(mid, batteries, n)) {
                left = mid;        // mid is possible → try higher
            } else {
                right = mid - 1;   // mid not possible → try lower
            }
        }
        return left;
    }

    private boolean canRun(long T, int[] batteries, int n) {
        long total = 0;

        for (int b : batteries) {
            total += Math.min(b, T);   // cap each battery at T
        }

        return total >= (long)n * T;
    }
}
