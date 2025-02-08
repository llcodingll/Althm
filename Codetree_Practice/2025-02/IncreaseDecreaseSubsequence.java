import java.util.*;
import java.io.*;

public class IncreaseDecreaseSubsequence {
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void init(){
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[j]<arr[i]) dp[i][0] = Math.max(dp[i][0], dp[j][0]+1);
                if(arr[j]>arr[i]) dp[i][1] = Math.max(dp[i][1], dp[j][1]+1);
            }
            dp[i][1] = Math.max(dp[i][0], dp[i][1]);
        }

        int answer = 0;
        for(int i = 0; i<n; i++){
            int tmpMax = Math.max(dp[i][0], dp[i][1]);
            answer = Math.max(answer, tmpMax);
        }

        System.out.print(answer);
    }
}