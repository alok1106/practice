class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for (int num : nums) {
            int sum = 1 + num; // 1 and num are always divisors
            int count = 2;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    int other = num / i;

                    if (i == other) {
                        count += 1;
                        sum += i;
                    } else {
                        count += 2;
                        sum += i + other;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                result += sum;
            }
        }

        return result;
    }
}
