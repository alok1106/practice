class Solution {
    public String sortVowels(String s) {
        boolean[] isVowel = new boolean[128];
        for (char v : "aeiouAEIOU".toCharArray()) {
            isVowel[v] = true;
        }

        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            if (isVowel[c]) {
                freq[c]++;
            }
        }

        char[] chars = s.toCharArray();
        int vowelIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isVowel[chars[i]]) {
                while (vowelIndex < 128 && freq[vowelIndex] == 0) {
                    vowelIndex++;
                }
                chars[i] = (char) vowelIndex;
                freq[vowelIndex]--;
            }
        }

        return new String(chars);
    }
}