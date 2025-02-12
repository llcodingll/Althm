import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void init(){
        for(int i = 0; i<n; i++){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = arr[0];
    }

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

        init();

        for(int i = 1; i<n; i++){
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}