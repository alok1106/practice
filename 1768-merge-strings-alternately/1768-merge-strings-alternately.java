class Solution {
    public String mergeAlternately(String word1, String word2) {
        String mergedString = "";
        int str1 = 0, str2 = 0, i = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        int n = n1 + n2;
        while(i < n) {
            if (n1 > 0) {
                mergedString += word1.charAt(str1++);
                n1--;
            }
            if (n2 > 0) {
                mergedString += word2.charAt(str2++);
                n2--;
            }
            i++;
        }
        return mergedString;
    }
}