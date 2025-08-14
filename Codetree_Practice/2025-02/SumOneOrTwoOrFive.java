import java.io.*;
import java.util.*;

public class SumOneOrTwoOrFive {
    static int n;
    static int m;
    static int[] coin = {1, 2, 5};
    static int[] dp;

    public static void init(){
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 9;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        init();

        for(int i = 6; i<=n; i++){
            int sum = 0;
            for(int j = 0; j<coin.length; j++){
                sum += dp[i-coin[j]]%10007;
            }
            dp[i] = sum%10007;
        }

        System.out.println(dp[n]);
    }
}