class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        Arrays.fill(ans, -1);

        for (int i = 0; i < ans.length; i++) {
            int temp_1 = nums.get(i);
            int min = Integer.MAX_VALUE;
            if (((temp_1 + 1) % temp_1) != 0) {
                for (int j = 0; j < 32; j++) {
                    if ((temp_1 & (1 << j)) != 0) {
                        int temp_2 = (temp_1 & ~(1 << j));
                        if ((temp_2 | temp_2 + 1) == temp_1) {
                            min = Math.min(min, temp_2);
                        }
                    }
                }
            if (min != Integer.MAX_VALUE) {
                ans[i] = min;
            }
            
            } else {
                int n = temp_1;
                int pos = -1;
                while (n > 0) {
                    pos++;
                    n = n >> 1;
                }
            }
        }

        return ans;
    }
}