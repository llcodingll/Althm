import java.io.*;
import java.util.*;
import java.lang.*;

public class MaxMinIntegerSquare {
    static int n;
    static int[][] grid;
    static int[][] dp;

    public static void init(){
        dp[0][0] = grid[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], grid[i][0]);
            dp[0][i] = Math.max(dp[0][i-1], grid[0][i]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                int min = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.max(min, grid[i][j]);
            }
        }

        System.out.print(dp[n-1][n-1]);
    }
}