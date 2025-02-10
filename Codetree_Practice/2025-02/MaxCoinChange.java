import java.util.*;
import java.io.*;

public class MaxCoinChange {
    static int n;
    static int m;
    static int[] coin;
    static int[] dp;

    public static void init(){
        for(int i = 0 ; i<m ;i++){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 0; i<=m; i++){
            for(int j = 0; j<n; j++){
                if(i>=coin[j]){
                    if(dp[i-coin[j]]==Integer.MIN_VALUE) continue;
                    dp[i] = Math.max(dp[i], dp[i-coin[j]]+1);
                }
            }
        }

        int answer = dp[m];
        if(answer == Integer.MIN_VALUE || answer == 0) answer = -1;
        System.out.print(answer);
    }
}