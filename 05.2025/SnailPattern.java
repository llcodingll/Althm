
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnailPattern {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int x = 0, y = 0, dir = 0;
            for (int num = 1; num <= N * N; num++) {
                snail[x][y] = num;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || snail[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
