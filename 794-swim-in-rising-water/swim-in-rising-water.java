class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        int time = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0];
            int row = curr[1];
            int col = curr[2];

            time = Math.max(time, height);

            if (row == n - 1 && col == n - 1) {
                return time;
            }

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] d : dirs) {
                int newRow = row + d[0];
                int newCol = col + d[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    pq.offer(new int[]{grid[newRow][newCol], newRow, newCol});
                }
            }
        }

        return -1;
    }
}
