class Solution {
    public int countOdds(int low, int high) {
        int N = high - low + 1;
        if(N % 2 == 0) return N/2;
        if(high % 2 != 0 || low % 2 != 0) return N/2 + 1;
        return N/2;
    }
}