class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.add(s);
        seen.add(s);
        String ans = s;

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(ans) < 0) ans = cur;

            char[] arr = cur.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int d = (arr[i] - '0' + a) % 10;
                arr[i] = (char) ('0' + d);
            }
            String added = new String(arr);
            if (seen.add(added)) q.add(added);

            int shift = b % n;
            if (shift != 0) {
                String rotated = cur.substring(n - shift) + cur.substring(0, n - shift);
                if (seen.add(rotated)) q.add(rotated);
            }
        }

        return ans;
    }
}
