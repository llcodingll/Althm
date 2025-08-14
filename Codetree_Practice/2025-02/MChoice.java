import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[][][] dp;
    /*
    dp[i][j][k] :
    i번째를 고려한 상황
    j개의 구간을 선택한 상황
    i번째 원소 포함 (k=0)안하는 경우 or (k=1)하는 경우
    얻을 수 있는 최대 점수
    */

    public static void init(){
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=m; j++){
                dp[i][j][0] = -500000;
                dp[i][j][1] = -500000;
            }
        }

        for(int i = 0; i<=n; i++){
            dp[i][0][0] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][m+1][2];

        init();

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                dp[i][j][1] = Math.max(dp[i-1][j-1][0]+arr[i], dp[i-1][j][1]+arr[i]);
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]);
            }
        }

        System.out.print(Math.max(dp[n][m][0], dp[n][m][1]));
    }
}