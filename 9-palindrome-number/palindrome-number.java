class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int reverse = reverse(x);
        return reverse == x;
    }

    int reverse(int x){
        int num = 0;
        while(x>0){
            int rem = x % 10;
            num= num*10 + rem;
            x = x/10;
            System.out.println(num);
        }
        System.out.println(num);
        return num;
    }
}