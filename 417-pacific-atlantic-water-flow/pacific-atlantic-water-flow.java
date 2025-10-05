class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, n - 1, atlantic, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, m - 1, j, atlantic, heights[m - 1][j]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] h, int i, int j, boolean[][] visited, int prevHeight) {
        int m = h.length, n = h[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (visited[i][j] || h[i][j] < prevHeight) return;

        visited[i][j] = true;

        dfs(h, i + 1, j, visited, h[i][j]);
        dfs(h, i - 1, j, visited, h[i][j]);
        dfs(h, i, j + 1, visited, h[i][j]);
        dfs(h, i, j - 1, visited, h[i][j]);
    }
}
