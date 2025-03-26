import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Cheese {
    static int N, loaf, max;
    static int[][] cheese, fairy;
    static boolean[][] visited, ate;
 
    static int[] di = { 0, 0, -1, 1 };
    static int[] dj = { -1, 1, 0, 0 };
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
 
            max = 1;
 
            cheese = new int[N][N];
            ate = new boolean[N][N];
 
            for (int i = 0; i < N; i++) {
                StringTokenizer inputs = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(inputs.nextToken());
                }
            }
 
            fairy = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    fairy[i][j] = cheese[i][j];
                }
            }
 
            for (int x = 0; x <= 100; x++) {
                loaf = 0;
                visited = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (fairy[i][j] == x) {
                            ate[i][j] = true;
                        }
                    }
                }
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!ate[i][j] && !visited[i][j]) {
                            bfs(x, i, j);
                            loaf++;
                        }
                    }
                }
                max = Math.max(loaf, max);
            }
             
            System.out.println("#" + t + " " + max);
        }
    }
 
    private static void bfs(int x, int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { r, c });
 
        visited[r][c] = true;
 
        while (!que.isEmpty()) {
            int[] curr = que.remove();
            for (int d = 0; d < 4; d++) {
                int ni = curr[0] + di[d];
                int nj = curr[1] + dj[d];
                if (ni >= 0 && ni < N && nj >= 0 && nj < N && !ate[ni][nj] && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    que.add(new int[] {ni, nj});
                }
            }
        }
    }
}