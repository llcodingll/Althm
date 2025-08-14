import java.io.*;

public class Main {
    final static int MAX_SEQ_B = 3;
    final static int MAX_T = 3;
    final static int MOD = 1000000007;
    static int n;
    static int[][][] dp; // dp[i][j][k] : i번째까지 고려했을 때, T가 총 j번, B가 최근 연속 k번 나온 경우 생존 가능 가짓수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int [n+1][MAX_SEQ_B+1][MAX_T+1];

        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;

        for(int i = 1; i<n; i++){
            for(int j = 0; j<MAX_T; j++){
                for(int k = 0; k<MAX_SEQ_B; k++){
                    dp[i+1][j][0] = (dp[i+1][j][0] + dp[i][j][k]) % MOD;
                    dp[i+1][j+1][0] = (dp[i+1][j+1][0] + dp[i][j][k]) % MOD;
                    dp[i+1][j][k+1] = (dp[i+1][j][k+1] + dp[i][j][k]) % MOD;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i<MAX_T; i++){
            for(int j = 0; j<MAX_SEQ_B; j++){
                ans = (ans+dp[n][i][j]) % MOD;
            }
        }

        System.out.println(ans);


    }
}