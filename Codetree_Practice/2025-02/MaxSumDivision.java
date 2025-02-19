import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int m;
    static int[] arr;
    static int[][] dp;
    final static int offset = 100000;

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = -m; j<m; j++){
                dp[i][j+offset] = Integer.MIN_VALUE;
            }
        }
        dp[0][0+offset] = 0;
    }

    public static void update(int i, int j, int prevI, int prevJ, int val){
        if(prevJ<-m || prevJ>m || dp[prevI][prevJ+offset] == Integer.MIN_VALUE) return ;
        dp[i][j+offset] = Math.max(dp[i][j+offset], dp[prevI][prevJ+offset]+val);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = 0;

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            m += arr[i];
        }

        // dp[i][j] : i번째 수 까지 고려했을 때 A의 합과 B의 합의 차이가 j일 때의 A의 최대 합
        dp = new int[n+1][m+1+offset];

        init();

        for(int i = 1; i<=n; i++){
            for(int j = -m; j<=m; j++){
                // Case 1. 그룹 A에 i번째 원소를 추가하여 그룹A-그룹B가 j가 된 경우
                // dp[i - 1][j - arr[i]] + arr[i] -> dp[i][j]
                update(i, j, i - 1, j - arr[i], arr[i]);

                // Case 2. 그룹 B에 i번째 원소를 추가하여 그룹A-그룹B가 j가 된 경우
                // dp[i - 1][j + arr[i]] -> dp[i][j]
                update(i, j, i - 1, j + arr[i], 0);

                // Case 3. 그룹 C에 i번째 원소를 추가하여 그룹A-그룹B가 j가 된 경우
                // dp[i - 1][j] -> dp[i][j]
                update(i, j, i  - 1, j, 0);
            }
        }

        System.out.print(dp[n][0+offset]);

    }
}