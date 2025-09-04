class Solution {
    public int findClosest(int x, int y, int z) {
        int distanceX = Math.abs(x-z);
        int distanceY = Math.abs(y-z);
        return distanceX < distanceY ? 1 : distanceX > distanceY ? 2 : 0;
    }
}