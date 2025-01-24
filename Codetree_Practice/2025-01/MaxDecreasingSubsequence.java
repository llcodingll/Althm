import java.io.*;
import java.util.*;
import java.lang.*;

public class MaxDecreasingSubsequence {
    static int n;
    static int[] arr;
    static int[] dp;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<n; i++){
            dp[i] = Math.max(1, dp[i]);
            for(int j = i; j<n; j++){
                if(arr[j]<arr[i]){
                    dp[j]= Math.max(dp[i]+1,dp[j]);
                }
                answer = Math.max(answer, dp[j]);
            }
        }

        System.out.print(answer);
    }
}