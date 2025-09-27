class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;

        for (int i = 0; i < n - 2; i++) {
            int[] P = points[i];
            for (int j = i + 1; j < n - 1; j++) {
                int[] Q = points[j];
                for (int k = j + 1; k < n; k++) {
                    int[] R = points[k];
                    
                    double area = 0.5 * Math.abs(
                          P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1]
                        - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]
                    );
                    
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
}
