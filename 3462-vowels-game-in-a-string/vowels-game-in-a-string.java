class Solution {
    public boolean doesAliceWin(String s) {
        if (s == null || s.isEmpty()) return false;

        boolean[] isVowel = new boolean[128];
        
        for (char v : "aeiouAEIOU".toCharArray()) isVowel[v] = true;

        for (char c : s.toCharArray()) {
            if (c < 128 && isVowel[c]) return true;
        }
        return false;
    }
}
