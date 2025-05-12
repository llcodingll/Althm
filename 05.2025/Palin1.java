
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palin1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int length = Integer.parseInt(br.readLine());
            String[] board = new String[8];

            for (int i = 0; i < 8; i++) {
                board[i] = br.readLine();
            }

            int count = 0;

            // 가로 방향 회문 탐색
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - length; j++) {
                    StringBuilder sb = new StringBuilder(board[i].substring(j, j + length));
                    if (sb.toString().equals(sb.reverse().toString())) {
                        count++;
                    }
                }
            }

            // 세로 방향 회문 탐색
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row <= 8 - length; row++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < length; k++) {
                        sb.append(board[row + k].charAt(col));
                    }
                    if (sb.toString().equals(sb.reverse().toString())) {
                        count++;
                    }
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
