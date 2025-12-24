class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApples = 0, minBox = 0;

        for (int i = 0; i < apple.length; i++) totalApples += apple[i];

        for(int i = capacity.length-1; i >= 0; i--){
            totalApples -= capacity[i];
            minBox++;
            if(totalApples <= 0) return minBox;
        }
        return minBox;
    }
}