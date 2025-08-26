class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int numberOfRectangles = dimensions.length;
        double maxDiagonal = 0.0;
        int maxArea = 0;
        for(int i = 0; i< numberOfRectangles ; i++){
            double diagonal = Math.sqrt(dimensions[i][0]*dimensions[i][0] + dimensions[i][1]*dimensions[i][1]);
            int area = dimensions[i][0] * dimensions[i][1];
            if(diagonal > maxDiagonal){
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (maxDiagonal == diagonal){
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}