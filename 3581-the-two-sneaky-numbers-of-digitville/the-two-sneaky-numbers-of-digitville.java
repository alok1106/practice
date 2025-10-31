import java.util.Arrays;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int N = nums.length;
        int[] res = new int[2];
        int idx = 0;

        for (int i = 0; i < N && idx < 2; i++) {
            int val = nums[i] % N;        
            if (nums[val] >= N) { 
                res[idx++] = val;
            } else {
                nums[val] += N;
            }
        }

        Arrays.sort(res);
        return res;
    }
}
