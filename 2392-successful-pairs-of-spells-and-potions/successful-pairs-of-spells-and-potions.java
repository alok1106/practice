class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int n = spells.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            long target = (success - 1L) / spells[i] + 1;

            int left = 0, right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = m - left;
        }
        
        return result;
    }
}