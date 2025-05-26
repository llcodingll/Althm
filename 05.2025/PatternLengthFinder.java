import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PatternLengthFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();

            int patternLength = 0;
            for (int i = 1; i <= 10; i++) {
                String pattern = str.substring(0, i);
                String next = str.substring(i, i + i);
                if (pattern.equals(next)) {
                    patternLength = i;
                    break;
                }
            }
            sb.append("#").append(t).append(" ").append(patternLength).append("\n");
        }
        System.out.print(sb);
    }
}