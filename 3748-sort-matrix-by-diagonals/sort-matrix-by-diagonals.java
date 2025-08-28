class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diag = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diag.computeIfAbsent(i - j, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        for (var e : diag.entrySet()) {
            List<Integer> list = e.getValue();
            int key = e.getKey();
            if (key >= 0) {
                list.sort(Comparator.reverseOrder()); // bottom-left (including main) -> descending
            } else {
                list.sort(Comparator.naturalOrder()); // top-right -> ascending
            }
        }

        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> list = diag.get(key);
                int k = idx.getOrDefault(key, 0);
                grid[i][j] = list.get(k);
                idx.put(key, k + 1);
            }
        }

        return grid;
    }
}