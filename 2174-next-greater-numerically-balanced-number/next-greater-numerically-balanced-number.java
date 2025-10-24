class Solution {
    public int nextBeautifulNumber(int n) {
        while (true) {
            n++;
            if (isBeautiful(n)) return n;
        }
    }

    boolean isBeautiful(int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            freq.put(digit, freq.getOrDefault(digit, 0) + 1);
            temp /= 10;
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (!entry.getKey().equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
