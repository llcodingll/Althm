
import java.util.Scanner;

public class WhereToPut {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 가로,세로 길이
            int K = sc.nextInt(); // 단어 길이
            sc.nextLine();
            // 흰 = 1, 검 = 0
            String[][] graph = new String[N][N];
            for (int i = 0; i < N; i++) {
                graph[i] = sc.nextLine().split(" ");
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                int oneCnt = 0;
                for (int j = 0; j < N; j++) {
                    if (graph[i][j].equals("1")) {
                        oneCnt++;
                    } else {
                        if (oneCnt == K) {
                            cnt++;
                        }
                        oneCnt = 0;
                    }
                }
                if (oneCnt == K) {
                    cnt++;
                }
            }

            for (int j = 0; j < N; j++) {
                int oneCnt = 0;
                for (int i = 0; i < N; i++) {
                    if (graph[i][j].equals("1")) {
                        oneCnt++;
                    } else {
                        if (oneCnt == K) {
                            cnt++;
                        }
                        oneCnt = 0;
                    }
                }
                if (oneCnt == K) {
                    cnt++;
                }

            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}
