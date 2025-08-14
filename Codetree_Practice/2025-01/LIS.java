import java.io.*;
import java.util.*;
import java.lang.*;

public class LIS {
    static int n;
    static int[][] grid;
    static int[][] dp;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static int findMax(int r, int c){
        if(dp[r][c] != 0) return dp[r][c];

        int best = 1;

        for(int i = 0; i<4; i++){
            int nextR = r+dirR[i];
            int nextC = c+dirC[i];
            if(isRange(nextR, nextC) && grid[r][c]<grid[nextR][nextC]){
                best = Math.max(best, findMax(nextR, nextC)+1);
            }
        }
        return dp[r][c] = best;
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<n && c>=0 && c<n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                answer = Math.max(answer, findMax(i,j));
            }
        }

        System.out.print(answer);
    }
}
