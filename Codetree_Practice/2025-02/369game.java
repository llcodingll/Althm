import java.io.*;
import java.math.BigInteger;

public class Main {
    static final int MOD = 1000000007;
    static int n;
    static long[] pt;
    static long[][] dp;
    // dp[i][j] : 처리한 자릿수의 수를 i라고 할 떄 3으로 나눈 나머지가 j.
    //            dp 테이블을 활용하여 자릿수 중에 3,6,9가 나타나지 않았고 각 자릿수의 합이 3의 배수이며
    //            이 뒤에 0-9 중 어느 숫자를 붙여도 되는 형태의 자릿수의 개수를 구함
    static long ans;
    static boolean isSuc;
    static int sm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        n = input.length();

        // 10의 거듭제곱(자릿수)을 미리 계산해둠
        pt = new long[n+1];
        pt[0] = 1;
        for(int i = 1; i<=n; i++){
            pt[i] = pt[i-1] * 10 % MOD;
        }

        dp = new long[n+1][3];

        for(int i = 0; i<n; i++){
            int num = input.charAt(i) - '0';
            for(int j = 0; j<10; j++){
                if(j == 3 || j == 6 || j == 9){
                    ans += (dp[i][0]+dp[i][1]+dp[i][2])*pt[n-i-1];
                    ans %= MOD;
                    continue;
                }

                for(int k = 0; k<3; k++){
                    dp[i+1][(j+k)%3] += dp[i][k];
                    dp[i+1][(j+k)%3] %= MOD;
                }
            }

            // 각 자리수가 num보다 작은 경우
            for(int j = 0; j<num; j++){
                if(isSuc || j == 3 || j == 6 || j == 9){
                    ans += pt[n-i-1];
                    ans %= MOD;
                }
                else{
                    dp[i+1][(j+sm)%3]++;
                    dp[i+1][(j+sm)%3] %= MOD;
                }
            }

            if(num == 3 || num == 6 || num == 9) isSuc = true;
            else sm += num;
        }

        if(isSuc) ans = (ans + 1) % MOD;
        else dp[n][sm % 3] = (dp[n][sm % 3] + 1) % MOD;

        ans += dp[n][0];
        ans += (MOD-1);
        ans %= MOD;
        System.out.print(ans);
    }
}