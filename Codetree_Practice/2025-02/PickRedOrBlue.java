import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] red;
    static int[] blue;
    static int[][][] dp; //dp[i][j][k] : 지금까지 i번째까지 고려했을 때, 빨간색을 j개, 파란색을 k개 고른 경우 최대값

    public static void init(){
        for(int i = 0; i<=2*n; i++){
            for(int j = 0; j<=2*n; j++){
                for(int k = 0; k<=2*n; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        red = new int[2*n+1];
        blue = new int[2*n+1];
        for(int i = 1; i<=2*n; i++){
            st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[2*n+1][2*n+1][2*n+1];
        init();

        for(int i = 1; i<=2*n; i++){
            for(int j = 0; j<=i; j++){
                for(int k = 0; k<=i; k++){
                    if(j>0){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][k]+red[i]);
                    }
                    if(k>0){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1]+blue[i]);
                    }
                }
            }
        }

        System.out.print(dp[2*n][n][n]);
    }
}