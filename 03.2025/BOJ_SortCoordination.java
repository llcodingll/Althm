
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_SortCoordination {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] coor = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer inputs = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                coor[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }

        for (int i = 0; i < N - 1; i++) {
            if (coor[i][0] > coor[i + 1][0]) {
                int tmp = coor[i][0];
                coor[i][0] = coor[i + 1][0];
                coor[i + 1][0] = tmp;
                for (int j = 0; j < N - 1; j++) {
                    if (coor[j][1] > coor[j + 1][1]) {
                        int tmp2 = coor[j][1];
                        coor[j][1] = coor[j + 1][1];
                        coor[j + 1][1] = tmp2;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(coor[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
