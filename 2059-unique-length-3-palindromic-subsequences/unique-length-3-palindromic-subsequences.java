class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];

        Arrays.fill(left, n);
        Arrays.fill(right, -1);

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int c = arr[i] - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = Math.max(right[c], i);
        }

        int answer = 0;

        for (int c = 0; c < 26; c++) {
            if (left[c] < right[c]) {
                boolean[] seen = new boolean[26];

                for (int mid = left[c] + 1; mid < right[c]; mid++) {
                    seen[arr[mid] - 'a'] = true;
                }

                for (boolean x : seen)
                    if (x) answer++;
            }
        }
        return answer;
    }
}
