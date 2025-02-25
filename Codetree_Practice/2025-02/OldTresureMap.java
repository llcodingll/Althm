import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int[] num;
    static int[][] dp; //dp[i][j] : i번째 숫자까지 고려했을 때, 음수의 개수가 j인 경우 연속합 중 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][k+1];

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++){
            if(num[i]>=0){
                for(int j = 0; j<=k; j++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+num[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            else{
                for(int j = 1; j<=k; j++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+num[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.print(ans);
    }
}