class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int total_time = 0;
        for(int i = 0; i < points.length - 1; i++){
            int[] current = points[i];
            int[] next = points[i+1];
            int x = Math.abs(next[0] - current[0]);
            int y = Math.abs(next[1] - current[1]);
            total_time += Math.max(x,y);
        }
        return total_time;
    }
}