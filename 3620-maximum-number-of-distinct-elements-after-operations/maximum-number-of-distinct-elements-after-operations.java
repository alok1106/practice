class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        int[][] ranges = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            ranges[i][0] = nums[i] - k;
            ranges[i][1] = nums[i] + k;
        }
        
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[1], b[1]));
        
        int curr = Integer.MIN_VALUE;
        int distinct = 0;
        
        for (int[] range : ranges) {
            int left = range[0];
            int right = range[1];
            
            if (curr < left) {
                curr = left;
            }
            
            if (curr >= left && curr <= right) {
                distinct++;
                curr++;
            }
        }
        
        return distinct;
    }
}
