import java.io.*;
import java.util.*;
import java.lang.*;

public class MaxJumpNum {
    static int n;
    static int[] arr;
    static int[] dp;
    static int answer = Integer.MIN_VALUE;

    public static void init(){
        dp[0] = 0;
        for(int i = 1; i<n; i++){
            dp[i] = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(dp[j] == Integer.MIN_VALUE) continue;
                if(j+arr[j] >= i) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        for(int i = 0; i<n; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}