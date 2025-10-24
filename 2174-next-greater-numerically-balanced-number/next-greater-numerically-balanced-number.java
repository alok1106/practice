class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBeautiful(num)) return num;
            num++;
        }
    }

    private boolean isBeautiful(int x) {
        int[] freq = new int[10];

        while (x > 0) {
            freq[x % 10]++;
            x /= 10;
        }

        for (int d = 0; d <= 9; d++) {
            if (freq[d] != 0 && freq[d] != d)
                return false;
        }

        return true;
    }
}
