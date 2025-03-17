// IL - DP2 : 연속적이지만 직전 상황에 영향을 받는 DP - 신전 탐험하기
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp; // dp[i][j] = i층까지 고려했을 때 마지막 방이 j인 경우 최대 보물의 개수(j = 0:왼쪽, 1:중앙, 2:오른쪽)
    static int[][] treasure;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        treasure = new int[n+1][3]; //0:왼쪽, 1:중앙, 2:오른쪽
        dp = new int[n+1][3]; //0:왼쪽, 1:중앙, 2:오른쪽

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            treasure[i][0] = Integer.parseInt(st.nextToken());
            treasure[i][1] = Integer.parseInt(st.nextToken());
            treasure[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<3; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i-1][(j+1)%3]+treasure[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][(j+2)%3]+treasure[i][j]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<3; i++){
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}