class Solution {
    public int countTriples(int n) {
        int count = 0;

        boolean[] square = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) {
            square[i * i] = true;
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int sum = a*a + b*b;
                if (sum <= n*n && square[sum]) {
                    count++;
                }
            }
        }

        return count;
    }
}