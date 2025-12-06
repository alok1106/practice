import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        Deque<Integer> min_deque = new ArrayDeque<>();
        Deque<Integer> max_deque = new ArrayDeque<>();
        
        long valid_dp_sum = 0;
        int j_min = 0;

        for (int i = 1; i <= n; i++) {
            int current_index = i - 1;
            int current_val = nums[current_index];

            while (!min_deque.isEmpty() && nums[min_deque.peekLast()] >= current_val) {
                min_deque.removeLast();
            }
            min_deque.addLast(current_index);

            while (!max_deque.isEmpty() && nums[max_deque.peekLast()] <= current_val) {
                max_deque.removeLast();
            }
            max_deque.addLast(current_index);

            valid_dp_sum = (valid_dp_sum + dp[i - 1]) % MOD;

            while (nums[max_deque.peekFirst()] - nums[min_deque.peekFirst()] > k) {
                
                valid_dp_sum = (valid_dp_sum - dp[j_min] + MOD) % MOD;
                
                if (min_deque.peekFirst() == j_min) {
                    min_deque.removeFirst();
                }
                if (max_deque.peekFirst() == j_min) {
                    max_deque.removeFirst();
                }

                j_min++;
            }

            dp[i] = valid_dp_sum;
        }

        return (int) dp[n];
    }
}