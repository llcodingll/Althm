import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ModeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int testCaseNumber = Integer.parseInt(br.readLine());
            int[] scoreCount = new int[101];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                scoreCount[score]++;
            }

            int mode = 0;
            int maxCount = 0;
            for (int i = 0; i <= 100; i++) {
                if (scoreCount[i] >= maxCount) {
                    maxCount = scoreCount[i];
                    mode = i;
                }
            }
            System.out.println("#" + testCaseNumber + " " + mode);
        }
    }
}
