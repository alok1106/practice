class Solution {

    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] prevZero = new int[n + 1];
        prevZero[0] = -1;

        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(i - 1) == '0') {
                prevZero[i + 1] = i;          
            } else {
                prevZero[i + 1] = prevZero[i];
            }
        }

        int total = 0;

        for (int end = 1; end <= n; end++) {
            int zeroCount = (s.charAt(end - 1) == '0') ? 1 : 0;
            int j = end;

            while (j > 0 && zeroCount * zeroCount <= n) {

                int onesCount = (end - prevZero[j]) - zeroCount;

                if (onesCount >= zeroCount * zeroCount) {

                    total += Math.min(
                        j - prevZero[j],
                        onesCount - zeroCount * zeroCount + 1
                    );
                }

                j = prevZero[j];
                zeroCount++;
            }
        }

        return total;
    }
}
