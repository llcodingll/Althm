
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectShuffle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            String inputs = br.readLine();

            String[] cards = inputs.split(" ");

            String[] result = new String[N];
            half(N, cards, result, 0, (N + 1) / 2);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println("#" + t + " " + sb);
        }
    }

    static void half(int N, String[] cards, String[] result, int i, int j) {
        for (int k = 0; k < N; k++) {
            if (k % 2 == 0) {
                result[k] = cards[i++];
            } else {
                result[k] = cards[j++];
            }
        }
    }
}
