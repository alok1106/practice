class Solution {
    public long flowerGame(int n, int m) {
        long odd_n = (long) (n + 1) / 2;
        long even_n = (long) n / 2;
        
        long odd_m = (long) (m + 1) / 2;
        long even_m = (long) m / 2;
        
        long case1 = odd_n * even_m;
        
        long case2 = even_n * odd_m;
        
        return case1 + case2;
    }
}