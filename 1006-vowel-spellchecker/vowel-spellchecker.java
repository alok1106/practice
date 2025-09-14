import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordsExact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> wordsLower = new HashMap<>();
        Map<String, String> wordsVowel = new HashMap<>();
        
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String devowel = devowel(lower);
            
            wordsLower.putIfAbsent(lower, word);
            wordsVowel.putIfAbsent(devowel, word);
        }
        
        String[] result = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (wordsExact.contains(query)) {
                result[i] = query; // exact match
            } else {
                String lower = query.toLowerCase();
                String devowel = devowel(lower);
                
                if (wordsLower.containsKey(lower)) {
                    result[i] = wordsLower.get(lower);
                } else if (wordsVowel.containsKey(devowel)) {
                    result[i] = wordsVowel.get(devowel);
                } else {
                    result[i] = "";
                }
            }
        }
        return result;
    }
    
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
