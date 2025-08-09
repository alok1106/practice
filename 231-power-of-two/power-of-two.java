class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n < 0) return false;
        if (n == 1) return true;
        int rem = 0;
        while(n>0){
            rem = n % 2;
            n = n/2;
            if (rem != 0) return false;
            if (n == 1) return true;
        }
        return true;
    }
}