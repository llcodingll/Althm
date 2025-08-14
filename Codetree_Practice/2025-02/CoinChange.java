import java.io.*;
import java.util.*;

public class CoinChange {
    static int n;
    static int m;
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=m ;i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i<=m; i++){
            for(int j = 0; j<n; j++){
                if(i>=coin[j]){
                    if(dp[i-coin[j]] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i-coin[j]]+1);
                }
            }
        }

        if(dp[m] == Integer.MAX_VALUE) dp[m] = -1;
        System.out.println(dp[m]);
    }
}