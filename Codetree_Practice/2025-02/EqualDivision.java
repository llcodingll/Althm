import java.util.*;
import java.io.*;

public class Main {
    static int n = 0;
    static int m = 0;
    static int[] num;
    static boolean[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            m+=num[i];
        }

        dp = new boolean[m+1]; // dp[i] : 수의 합이 i가 될 수 있는지
        dp[0] = true;

        for(int i = 0; i<n; i++){
            for(int j = m; j>=0; j--){
                if(j>=num[i] && dp[j-num[i]]) dp[j] = true;
            }
        }

        if(m%2 == 0 && dp[m/2]) System.out.print("Yes");
        else System.out.print("No");
    }
}