class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;

        // Add boundaries
        int[] H = new int[hFences.length + 2];
        int[] V = new int[vFences.length + 2];

        H[0] = 1;
        H[H.length - 1] = m;
        V[0] = 1;
        V[V.length - 1] = n;

        System.arraycopy(hFences, 0, H, 1, hFences.length);
        System.arraycopy(vFences, 0, V, 1, vFences.length);

        Arrays.sort(H);
        Arrays.sort(V);

        // All possible horizontal gaps
        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < H.length; i++) {
            for (int j = i + 1; j < H.length; j++) {
                hGaps.add(H[j] - H[i]);
            }
        }

        long maxSide = -1;

        // Check vertical gaps against horizontal ones
        for (int i = 0; i < V.length; i++) {
            for (int j = i + 1; j < V.length; j++) {
                int gap = V[j] - V[i];
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }
}
