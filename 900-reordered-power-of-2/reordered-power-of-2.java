class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] countNDigits = countDigits(n);

        for(int i = 0; i < 31; i++){
            int powerOfTwo = 1 << i;
            int[] powerOfTwoCount = countDigits(powerOfTwo);

            if(Arrays.equals(countNDigits, powerOfTwoCount)){
                return true;
            }
        }
        return false;
    }

    private int[] countDigits(int n){
        int[] count = new int[10];
        if (n == 0){
            count[0]++;
            return count;
        }
        while (n>0){
            count[n%10]++;
            n /= 10;
        }
        return count;
    }
}