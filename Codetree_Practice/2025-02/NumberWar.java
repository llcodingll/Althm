import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] first;
    static int[] second;
    static int[][] dp; // dp[i][j] : 첫 번째 플레이어의 카드가 i번째, 두 번째 플레이어의 카드가 j번째일 때의 최고 점수

    public static void init(){
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        first = new int[n+1];
        second = new int[n+1];
        dp = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            first[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            second[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][n+1];
        init();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(dp[i][j] == -1) continue;
                if(first[i+1]<second[j+1]) dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                if(first[i+1]>second[j+1]) dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]+second[j+1]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
            }
        }

        int ans = 0;
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.print(ans);

    }
}