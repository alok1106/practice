class Solution {
    public int smallestNumber(int n) {
        int[] answerList = {0,1,3,7,15,31,63,127,255,511,1023};
        for(int i = 0; i<11; i++) {
            if(n <= answerList[i]) {
                return answerList[i];
            }
        }
        return 0;
    }
}