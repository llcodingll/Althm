import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] sticks;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        sticks = new int[n+1];
        dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        sticks[0] = 0;
        for(int i = 1; i<=n; i++){
            sticks[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = sticks[1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[i-j]+sticks[j]);
            }
        }

        System.out.print(dp[n]);
    }
}