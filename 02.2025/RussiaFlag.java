import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RussiaFlag {
    public static char[][] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            flag = new char[N][M];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    flag[i][j] = line.charAt(j);
                }
            }

            int ans = 2501;
            for (int i = 0; i < N-2; i++) {
                for (int j = i+1; j < N-1; j++) {
                    int paintingCount = painting(i,j,N,M);
                    ans = Math.min(ans, paintingCount);
                }
            }
            System.out.printf("#%d %d%n", t, ans);
        }

    }
    public static int painting(int i , int j, int N, int M){
        int toWhite = 0, toBlue = 0, toRed = 0;
        for (int k = 0; k < i+1; k++) {
            for (int l = 0; l < M; l++) {
                if(flag[k][l] != 'W') toWhite++;
            }
        }
        for (int k = i+1; k < j+1; k++) {
            for (int l = 0; l < M; l++) {
                if(flag[k][l] != 'B') toBlue++;
            }
        }
        for (int k = j+1; k < N; k++) {
            for (int l = 0; l < M; l++) {
                if(flag[k][l] != 'R') toRed++;
            }
        }
        return toWhite + toBlue + toRed;
    }
}
