import java.io.*;
import java.util.*;

public class TwoDimMaxIncreasingSequence {
    static int n;
    static int m;
    static int[][] grid;
    static int[][] dp;
    static int answer = Integer.MIN_VALUE;

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        dp = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                for(int k = 1; k<n-i; k++){
                    for(int l = 1; l<m-j; l++){
                        if(grid[i][j] < grid[i+k][j+l]){
                            dp[i+k][j+l] = Math.max(dp[i+k][j+l], dp[i][j]+1);
                        }
                    }
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.print(answer);
    }
}