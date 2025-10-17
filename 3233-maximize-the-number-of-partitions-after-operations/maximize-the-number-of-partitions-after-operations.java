class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(s, 0, 1, 0, k, memo) + 1;
    }

    private int dfs(String s, int i, int canChange, int mask, int k, Map<Long, Integer> memo) {
        if (i == s.length()) return 0;
        long key = ((long)i << 27) | ((long)canChange << 26) | mask;
        if (memo.containsKey(key)) return memo.get(key);

        int res = getRes(s, i, canChange, mask, 1 << (s.charAt(i) - 'a'), k, memo);

        if (canChange == 1) {
            for (int c = 0; c < 26; ++c) {
                res = Math.max(res, getRes(s, i, 0, mask, 1 << c, k, memo));
            }
        }

        memo.put(key, res);
        return res;
    }

    private int getRes(String s, int i, int nextCanChange, int mask, int addBit, int k, Map<Long, Integer> memo) {
        int newMask = mask | addBit;
        if (Integer.bitCount(newMask) > k) {
            return 1 + dfs(s, i + 1, nextCanChange, addBit, k, memo);
        } else {
            return dfs(s, i + 1, nextCanChange, newMask, k, memo);
        }
    }
}
