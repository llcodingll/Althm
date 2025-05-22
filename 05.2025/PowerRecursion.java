import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PowerRecursion {
    public static int power(int n, int m) {
        if (m == 0) return 1;
        return n * power(n, m - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            String tcLine = br.readLine();
            int t = Integer.parseInt(tcLine.trim());
            String[] nm = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int result = power(n, m);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
}