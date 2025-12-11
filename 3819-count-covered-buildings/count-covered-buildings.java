class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        // Build row and column maps
        for (int[] b : buildings) {
            rowMap.computeIfAbsent(b[1], k -> new ArrayList<>()).add(b[0]);
            colMap.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b[1]);
        }

        // Sort each row and column list
        for (List<Integer> list : rowMap.values()) Collections.sort(list);
        for (List<Integer> list : colMap.values()) Collections.sort(list);

        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> row = rowMap.get(y);
            List<Integer> col = colMap.get(x);

            // position in sorted lists
            int rx = Collections.binarySearch(row, x);
            int cy = Collections.binarySearch(col, y);

            boolean hasLeft  = rx > 0;
            boolean hasRight = rx >= 0 && rx < row.size() - 1;

            boolean hasAbove = cy > 0;
            boolean hasBelow = cy >= 0 && cy < col.size() - 1;

            if (hasLeft && hasRight && hasAbove && hasBelow) {
                covered++;
            }
        }

        return covered;
    }
}
