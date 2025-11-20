class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        // Sort by right endpoint asc, left endpoint desc
        Arrays.sort(intervals, (a, b) -> 
            (a[1] == b[1]) ? b[0] - a[0] : a[1] - b[1]
        );

        int p1 = -1; 
        int p2 = -1;

        int count = 0;

        for (int[] it : intervals) {
            int l = it[0], r = it[1];

            boolean c1 = p1 >= l;
            boolean c2 = p2 >= l;

            if (c1 && c2) {
                continue;
            }

            if (c1) {
                count++;
                p2 = p1;
                p1 = r;
            } else {
                count += 2;
                p2 = r - 1;
                p1 = r;
            }
        }

        return count;
    }
}