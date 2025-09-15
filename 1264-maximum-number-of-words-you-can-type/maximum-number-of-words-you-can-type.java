class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        
        int count = 0;
        boolean canType = true;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if (c == ' ') {
                if (canType) count++;
                canType = true;
            } else {
                if (broken[c - 'a']) {
                    canType = false;
                }
            }
        }
        
        if (canType) count++;
        
        return count;
    }
}