import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPalindrome {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] str = br.readLine().split("");

            System.out.print("#" + t + " ");
            boolean flag = false;
            outer: for (int i = 0; i < N - M + 1; i++) {
                if (str[i].equals(str[i + M - 1])) {
                    for (int j = 1; j <= M / 2; j++) {
                        if (!str[i + j].equals(str[i + M - 1 - j])) {
                            break;
                        } else {
                            if (j == M / 2) {
                                flag = true;
                                for (int k = 0; k < M; k++) {
                                    System.out.print(str[i + k]);
                                }
                                break outer;
                            }
                        }
                    }
                }

            }
            if (!flag)
                System.out.print("NONE");
            System.out.println();

        }
    }
}