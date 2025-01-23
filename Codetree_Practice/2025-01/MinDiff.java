import java.util.*;
import java.io.*;
import java.lang.*;

public class MinDiff {
    static int n;
    static int[][] grid;
    static int[][][] dp; // dp[i][j][k] : (1,1)에서 (i,j)까지 이동한 경로 중 가장 작은 값을 k라 했을 때 경로 중 있었던 수들 중 가장 큰 값 중 가능한 최솟값

    static int answer = Integer.MAX_VALUE;

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<100; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        dp[0][0][grid[0][0]] = grid[0][0];

        for(int i = 1; i<n; i++){
            for(int k = 1; k<100; k++){
                int min = Math.min(k, grid[i][0]);
                dp[i][0][min] = Math.min(dp[i][0][min], Math.max(dp[i-1][0][k],grid[i][0]));
            }
        }

        for(int j = 1; j<n; j++){
            for(int k = 1; k<100; k++){
                int min = Math.min(k, grid[0][j]);
                dp[0][j][min] = Math.min(dp[0][j][min], Math.max(dp[0][j-1][k],grid[0][j]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        dp = new int[n][n][100];
        for(int i = 0 ; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for(int i = 1; i<n; i++){
            for(int j = 1; j<n; j++){
                for(int k = 1; k<100; k++){
                    int min = Math.min(k, grid[i][j]);
                    dp[i][j][min] = Math.min(
                            dp[i][j][min],
                            Math.max(Math.min(dp[i-1][j][k],dp[i][j-1][k]), grid[i][j]));
                }
            }
        }

        for(int k = 0; k< 100; k++){
            if(dp[n-1][n-1][k] != Integer.MAX_VALUE) answer = Math.min(answer, dp[n-1][n-1][k] - k);
        }
        System.out.print(answer);
    }
}