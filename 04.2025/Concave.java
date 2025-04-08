import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Concave {
    static int N;
    static String[][] concave;
    static int[] di = { 0, 0, 1, -1, -1, -1, 1, 1 };
    static int[] dj = { -1, 1, 0, 0, -1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            concave = new String[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    concave[i][j] = input[j];
                }
            }

            String ans = "NO";
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (concave[i][j].equals("o")) {
                        if(ex(i, j)) ans = "YES";
                    }
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }

    static boolean ex(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int cnt = 1;
            for (int k = 1; k < 5; k++) {
                int nr = r + di[d] * k;
                int nc = c + dj[d] * k;
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (concave[nr][nc].equals("o")) cnt++;
                }
            }
            if(cnt == 5) return true;
        }
        return false;
    }
}
