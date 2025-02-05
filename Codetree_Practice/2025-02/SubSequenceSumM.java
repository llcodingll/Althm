import java.io.*;
import java.util.*;

public class SubSequenceSumM {
    static int n;
    static int m;
    static int[] subSeq;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        subSeq = new int[n];
        dp = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            subSeq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=m ;i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<n; i++){
            for(int j = m; j>=0; j--){
                if(j>=subSeq[i]){
                    if(dp[j-subSeq[i]] == Integer.MAX_VALUE) continue;
                    dp[j] = Math.min(dp[j], dp[j-subSeq[i]]+1);
                }
            }
        }

        if(dp[m] == Integer.MAX_VALUE) dp[m] = -1;
        System.out.println(dp[m]);
    }
}