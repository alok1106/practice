class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0, high = 0;
        double totalArea = 0;

        // Compute search space and total area
        for (int[] s : squares) {
            double y = s[1];
            double side = s[2];
            high = Math.max(high, y + side);
            totalArea += side * side;
        }

        double half = totalArea / 2.0;

        // Binary search
        for (int i = 0; i < 60; i++) { // sufficient precision
            double mid = (low + high) / 2;
            double below = areaBelow(squares, mid);

            if (below < half) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double areaBelow(int[][] squares, double yLine) {
        double area = 0;

        for (int[] s : squares) {
            double bottom = s[1];
            double side = s[2];
            double top = bottom + side;

            if (yLine <= bottom) {
                continue;
            } else if (yLine >= top) {
                area += side * side;
            } else {
                area += (yLine - bottom) * side;
            }
        }

        return area;
    }
}
