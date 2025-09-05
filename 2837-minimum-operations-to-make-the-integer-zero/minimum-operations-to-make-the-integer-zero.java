class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long operations = 0; operations <= 60; operations++) {
            long remaining = num1 - operations * num2;
            if (remaining < operations) {
                continue;
            }
            int bitsNeeded = Long.bitCount(remaining);
            if (bitsNeeded <= operations) {
                return (int) operations;
            }
        }
        return -1;
    }
}
