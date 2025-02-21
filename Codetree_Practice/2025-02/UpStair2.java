import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] coin;
    static int[][] dp; //dp[i][j] : 계단을 i칸 오른 상황에서 1칸 오른 횟수가 j일때 최대 동전 개수

    public static void init(){
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=3; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        coin = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n+1][4];

        init();

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=3; j++){
                // 1칸 올라서 이번 칸에 올라온 경우
                if(j>=1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+coin[i]);
                }
                // 2칸 올라서 이번 칸에 올라온 경우
                if(i>=2){
                    dp[i][j] = Math.max(dp[i][j], dp[i-2][j]+coin[i]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<=3; i++){
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.print(ans);
    }
}