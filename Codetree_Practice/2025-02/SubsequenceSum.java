import java.util.*;
import java.io.*;

public class SubsequenceSum {
    static int n;
    static int m;
    static int[] arr;
    static int[] dp;

    public static void init(){
        for(int i = 0; i<=m; i++){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 0; i<n; i++){
            for(int j = m; j>=0; j--){
                if(j>=arr[i]){
                    if(dp[j-arr[i]] == Integer.MIN_VALUE) continue;
                    dp[j] = Math.max(dp[j], dp[j-arr[i]]+1);
                }
            }
        }

        if(dp[m] == Integer.MIN_VALUE) System.out.print("No");
        else System.out.print("Yes");
    }
}