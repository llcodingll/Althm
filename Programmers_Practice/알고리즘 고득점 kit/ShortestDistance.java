import java.util.*;

class Solution {
    static int[] dir_R = {0, 0, 1, -1};
    static int[] dir_C = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            if (r == n-1 && c == m-1) return dist;

            for (int i = 0; i < 4; i++) {
                int nextR = r + dir_R[i];
                int nextC = c + dir_C[i];

                if (canGo(nextR, nextC, maps, visited, n, m)) {
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC, dist + 1});
                }
            }
        }

        return -1;
    }

    private boolean canGo(int r, int c, int[][] maps, boolean[][] visited, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m && !visited[r][c] && maps[r][c] == 1;
    }
}