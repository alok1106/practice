class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = longestConsecutive(hBars);
        int maxV = longestConsecutive(vBars);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }

    private int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);
        int max = 1, cur = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
