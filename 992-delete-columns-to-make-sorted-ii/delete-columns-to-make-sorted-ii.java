class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

        for (int c = 0; c < m; c++) {
            boolean bad = false;

            // Step A: check if this column breaks order
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(c) > strs[i + 1].charAt(c)) {
                    bad = true;
                    break;
                }
            }

            if (bad) {
                deletions++;
                continue;
            }

            // Step B: update sorted status
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(c) < strs[i + 1].charAt(c)) {
                    sorted[i] = true;
                }
            }
        }

        return deletions;
    }
}
