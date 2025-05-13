import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String word = br.readLine();

            StringBuilder sb = new StringBuilder(word);
            String reversed = sb.reverse().toString();

            int result = word.equals(reversed) ? 1 : 0;

            System.out.println("#" + t + " " + result);
        }
    }
}
