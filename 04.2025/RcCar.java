import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RcCar {
    static int N, Q, C, startI, startJ;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static char[][] park, command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            park = new char[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    park[i][j] = str.charAt(j);
                    if(park[i][j] == 'X'){
                        startI = i;
                        startJ = j;
                    }
                }
            }

            Q = Integer.parseInt(br.readLine());
            command = new char[Q][];
            for (int i = 0; i < Q; i++) {
                String[] str = br.readLine().split(" ");
                C = Integer.parseInt(str[0]);
                command[i] = str[1].toCharArray();
            }

            int[] ans = new int[Q];
            for (int i = 0; i < Q; i++) {
                for (int d = 0; d < 4; d++) {
                    if (simulate(startI, startJ, command[i], d) == 1) {
                        ans[i] = 1;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < Q; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    static int simulate(int r, int c, char[] cmd, int dir) {
        int i = r, j = c;

        for (char ch : cmd) {
            if (ch == 'R') {
                dir = (dir + 1) % 4;
            } else if (ch == 'L') {
                dir = (dir + 3) % 4;
            } else if (ch == 'A') {
                int ni = i + di[dir];
                int nj = j + dj[dir];
                if (ni >= 0 && ni < N && nj >= 0 && nj < N && park[ni][nj] != 'T') {
                    i = ni;
                    j = nj;
                }
            }
        }

        return park[i][j] == 'Y' ? 1 : 0;
    }
}
