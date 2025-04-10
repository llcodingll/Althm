
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MazeOne {

    static int startI, startJ;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            maze = new int[16][16];
            visited = new boolean[16][16];

            for (int i = 0; i < 16; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = Integer.parseInt(str[j]);
                    if (maze[i][j] == 2) {
                        startI = i;
                        startJ = j;
                    }
                }
            }

            int ans = ex(startI, startJ) ? 1 : 0;

            System.out.println("#" + T + " " + ans);
        }
    }

    static boolean ex(int r, int c) {
        if (maze[r][c] == 3) {
            return true;
        }

        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !visited[nr][nc] && maze[nr][nc] != 1) {
                visited[nr][nc] = true;
                if (ex(nr, nc)) {
                    return true;
                }
            }
        }
        return false;
    }
}
