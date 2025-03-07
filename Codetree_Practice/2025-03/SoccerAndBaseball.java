import java.io.*;
import java.util.*;

class Status{
    int s;
    int b;

    public Status(int s, int b){
        this.s = s;
        this.b = b;
    }
}

public class Main {
    static int n;
    static Status[] statList;
    static int[][][] dp; // dp[i][j][k] : i번째 학생까지 고려했을 떄 축구팀에 j명, 야구팀에 k명 뽑은 경우 능력의 최대 합

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        statList = new Status[n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            statList[i] = new Status(s, b);
        }

        dp = new int[n+1][12][10];

        // 3가지 경우가 있음. i번째 학생을 (1) 축구팀에 넣는 경우 (2) 야구팀에 넣는 경우 (3) 어느 팀에도 넣지 않은 경우
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=11; j++){
                for(int k = 0; k<=9; k++){
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
                    if(j>0 && j+k<=i) dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][k]+statList[i].s);
                    if(k>0 && j+k<=i) dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1]+statList[i].b);
                }
            }
        }

        System.out.print(dp[n][11][9]);

    }
}