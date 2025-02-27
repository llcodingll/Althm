import java.util.*;
import java.io.*;

public class Main {
    final static int offset = 20;
    static int n;
    static int m;
    static int[] num;
    static long[][] dp; // dp[i][j] : 숫자를 i개 고려했을 때 합이 j인 경우의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n+1];
        dp = new long[n+1][2*offset+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0+offset] = 1;

        for(int i = 1; i<=n; i++){
            for(int j = -1*offset; j<=offset; j++){
                if(j+num[i]<=20) dp[i][j+num[i]+offset] += dp[i-1][j+offset];
                if(j-num[i]>=-20) dp[i][j-num[i]+offset] += dp[i-1][j+offset];
            }
        }

        System.out.print(dp[n][m+offset]);
    }
}