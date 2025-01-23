import java.util.*;
import java.io.*;
import java.lang.*;

class MinMax{
    int min;
    int max;

    public MinMax(int min, int max){
        this.min = min;
        this.max = max;
    }
}

public class MinDiff {
    static int n;
    static int[][] grid;
    static MinMax[][] dp;

    public static void init(){
        dp[0][0] = new MinMax(grid[0][0], grid[0][0]);

        for(int i=1; i<n; i++){
            dp[i][0] = new MinMax(grid[i][0], grid[i][0]);
            dp[i][0].min = Math.min(dp[i-1][0].min, grid[i][0]);
            dp[i][0].max = Math.max(dp[i-1][0].max, grid[i][0]);

            dp[0][i] = new MinMax(grid[0][i], grid[0][i]);
            dp[0][i].min = Math.min(dp[0][i-1].min, grid[0][i]);
            dp[0][i].max = Math.max(dp[0][i-1].max, grid[0][i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        dp = new MinMax[n][n];
        for(int i = 0 ; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                int tmpRightMin = Math.min(dp[i][j-1].min, grid[i][j]);
                int tmpRightMax = Math.max(dp[i][j-1].max, grid[i][j]);
                int tmpDownMin = Math.min(dp[i-1][j].min, grid[i][j]);
                int tmpDownMax = Math.max(dp[i-1][j].max, grid[i][j]);

                if(tmpRightMax-tmpRightMin > tmpDownMax-tmpDownMin)dp[i][j] = new MinMax(tmpDownMin, tmpDownMax);
                else if(tmpRightMax-tmpRightMin == tmpDownMax-tmpDownMin){
                    if(tmpRightMax>tmpDownMax) dp[i][j] = new MinMax(tmpDownMin, tmpDownMax);
                    else dp[i][j] = new MinMax(tmpRightMin, tmpRightMax);
                }
                else dp[i][j] = new MinMax(tmpRightMin, tmpRightMax);
                //System.out.println(dp[i][j].min+", "+dp[i][j].max);
            }
        }

        System.out.print(dp[n-1][n-1].max - dp[n-1][n-1].min);
    }
}