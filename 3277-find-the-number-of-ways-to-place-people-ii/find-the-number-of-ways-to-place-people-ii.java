class Solution {

    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, Comparator
                .comparingInt((int[] point) -> point[0])
                .thenComparingInt(point -> -point[1]));

        int totalPairs = 0;
        int totalPoints = points.length;

        for (int i = 0; i < totalPoints; i++) {
            int upperLeftY = points[i][1];
            int maxValidLowerRightY = Integer.MIN_VALUE;

            for (int j = i + 1; j < totalPoints; j++) {
                int lowerRightY = points[j][1];

                if (lowerRightY <= upperLeftY && lowerRightY > maxValidLowerRightY) {
                    totalPairs++;
                    maxValidLowerRightY = lowerRightY;
                }
            }
        }
        return totalPairs;
    }
}
