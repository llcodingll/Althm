import java.io.*;

public class Main {
    final static int MAX = 1000000007;

    static int n;
    static int[][] dp; // dp[i][j] : i번째까지 고려했을 때 맨 마지막 수가 j인 경우 가능한 계단 수의 최대 가짓수

    public static void init(){
        for(int i = 1; i<10; i++){
            dp[1][i] = 1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];

        init();

        for(int i = 1; i<n; i++){
            for(int j = 0; j<10; j++){
                for(int k = 0; k<10; k++){
                    if(Math.abs(j-k) == 1){
                        dp[i+1][j] = (dp[i+1][j]+dp[i][k]) % MAX;
                    }
                }
            }
        }

        int ans = 0;

        for(int i = 0; i<10; i++){
            ans = (ans+dp[n][i]) % MAX;
        }

        System.out.print(ans);
    }
}