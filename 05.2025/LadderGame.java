
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LadderGame {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
            int x = 0;
            for (int j = 0; j < 100; j++) {
                if (map[99][j] == 2) {
                    x = j;
                    break;
                }
            }
            for (int i = 99; i >= 0; i--) {
                if (x > 0 && map[i][x - 1] == 1) {
                    while (x > 0 && map[i][x - 1] == 1) {
                        x--;
                    }
                } else if (x < 99 && map[i][x + 1] == 1) {
                    while (x < 99 && map[i][x + 1] == 1) {
                        x++;
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(x).append("\n");
        }

        System.out.print(sb);
    }
}
