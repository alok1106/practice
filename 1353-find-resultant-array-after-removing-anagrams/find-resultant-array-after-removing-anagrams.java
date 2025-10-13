class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for(int i = 1; i < words.length ; i++){
            boolean isAnagram = isAnagram(words[i], words[i-1]);
            if(!isAnagram){
                result.add(words[i]);
            }
        }
        return result;
    }

    static boolean isAnagram(String s1, String s2) {
        
        if (s1.length() != s2.length()) return false;
        
        int[] freq = new int[26];  

        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;

        for (int i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}