
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubStringChecker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str1 = br.readLine();
            String str2 = br.readLine();

            int result = str2.contains(str1) ? 1 : 0;

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
}
