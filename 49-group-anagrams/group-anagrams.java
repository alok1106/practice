class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null | strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs){
            int[] keyArray = getCharacterCount(word);
            String key = Arrays.toString(keyArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public int[] getCharacterCount(String str){
        int[] count = new int[26];
        for(char c : str.toCharArray()){
            count[c - 'a']++;
        }
        return count;
    }
}