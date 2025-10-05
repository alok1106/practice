class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific, heights[row][0]);           
            dfs(heights, row, cols - 1, atlantic, heights[row][cols - 1]);
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific, heights[0][col]);           
            dfs(heights, rows - 1, col, atlantic, heights[rows - 1][col]);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols) return;

        if (visited[row][col] || heights[row][col] < prevHeight) return;

        visited[row][col] = true;

        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }
}
