
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] num;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            m+=num[i];
        }
        dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=m; j++){
                if(j>=num[i] && dp[i-1][j-num[i]]) dp[i][j] = true;
                if(dp[i-1][j]) dp[i][j] = true;
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i<m; i++){
            if(dp[n][i]) ans = Math.min(ans, Math.abs(i-(m-i)));
        }

        System.out.print(ans);
    }
}