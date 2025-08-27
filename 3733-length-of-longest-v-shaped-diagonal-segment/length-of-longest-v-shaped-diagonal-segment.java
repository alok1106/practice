class Solution {
    private static final int[] DX = { 1,  1, -1, -1};
    private static final int[] DY = { 1, -1, -1,  1};
    private static final int[] CW = {1, 2, 3, 0};

    private static int eVal(int eIdx) { return eIdx == 0 ? 2 : 0; }

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][][] ext = new int[4][2][n][m];

        for (int d = 0; d < 4; d++) {
            int di = DX[d], dj = DY[d];

            int iStart = (di == 1) ? n - 1 : 0;
            int iEnd   = (di == 1) ? -1     : n;
            int iStep  = (di == 1) ? -1     : 1;

            int jStart = (dj == 1) ? m - 1 : 0;
            int jEnd   = (dj == 1) ? -1     : m;
            int jStep  = (dj == 1) ? -1     : 1;

            for (int i = iStart; i != iEnd; i += iStep) {
                for (int j = jStart; j != jEnd; j += jStep) {
                    for (int eIdx = 0; eIdx < 2; eIdx++) {
                        if (grid[i][j] != eVal(eIdx)) {
                            ext[d][eIdx][i][j] = 0;
                        } else {
                            int ni = i + di, nj = j + dj;
                            int add = 0;
                            if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                                add = ext[d][1 - eIdx][ni][nj];
                            }
                            ext[d][eIdx][i][j] = 1 + add;
                        }
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 1) continue;

                for (int d = 0; d < 4; d++) {
                    int di = DX[d], dj = DY[d];

                    int si = i + di, sj = j + dj;
                    int straight = 1;
                    if (si >= 0 && si < n && sj >= 0 && sj < m) {
                        straight += ext[d][0 /* expect 2 */][si][sj];
                    }
                    ans = Math.max(ans, straight);

                    int cw = CW[d];
                    int lenSoFar = 1;
                    int eIdx = 0;     
                    int x = i, y = j;

                    int ti = x + DX[cw], tj = y + DY[cw];
                    int tail = 0;
                    if (ti >= 0 && ti < n && tj >= 0 && tj < m) {
                        tail = ext[cw][eIdx][ti][tj];
                    }
                    ans = Math.max(ans, lenSoFar + tail);

                    while (true) {
                        int nx = x + di, ny = y + dj;
                        if (!(nx >= 0 && nx < n && ny >= 0 && ny < m)) break;
                        if (grid[nx][ny] != eVal(eIdx)) break;

                        x = nx; y = ny;
                        lenSoFar++;
                        eIdx ^= 1;

                        ti = x + DX[cw]; tj = y + DY[cw];
                        tail = 0;
                        if (ti >= 0 && ti < n && tj >= 0 && tj < m) {
                            tail = ext[cw][eIdx][ti][tj];
                        }
                        ans = Math.max(ans, lenSoFar + tail);
                    }
                }
            }
        }

        return ans;
    }
}
