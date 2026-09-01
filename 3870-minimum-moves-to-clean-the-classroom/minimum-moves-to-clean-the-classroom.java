class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int startR = 0, startC = 0, litterCount = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }

        if (litterCount == 0) return 0;
        int targetMask = (1 << litterCount) - 1;

        int[][][] maxEnergySeen = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergySeen[i][j], -1);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startR, startC, 0, energy, 0});
        maxEnergySeen[startR][startC][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], mask = cur[2], e = cur[3], moves = cur[4];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (classroom[nr].charAt(nc) == 'X') continue;

                int nextEnergy = e - 1;
                if (nextEnergy < 0) continue;

                int nextMask = mask;
                char cell = classroom[nr].charAt(nc);

                if (cell == 'R') {
                    nextEnergy = energy;
                } else if (cell == 'L') {
                    nextMask |= (1 << litterId[nr][nc]);
                }

                if (nextMask == targetMask) {
                    return moves + 1;
                }

                if (nextEnergy <= maxEnergySeen[nr][nc][nextMask]) {
                    continue;
                }

                maxEnergySeen[nr][nc][nextMask] = nextEnergy;
                queue.add(new int[]{nr, nc, nextMask, nextEnergy, moves + 1});
            }
        }

        return -1;
    }
}