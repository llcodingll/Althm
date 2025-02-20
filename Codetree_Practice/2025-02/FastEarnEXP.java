import java.util.*;
import java.io.*;

class Quest{
    int e;
    int t;
    public Quest(int e, int t){
        this.e = e;
        this.t = t;
    }
}

public class Main {
    static int n;
    static int m;
    static Quest[] list;
    static int dp[];

    final static int MAX_T = 10000;

    public static void init(){
        for(int i = 0; i<=MAX_T; i++){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new Quest[n];
        dp = new int[MAX_T + 1]; // dp[i] = 시간의 합이 i일때 경험치의 최대 합

        for(int i = 0; i<n; i++){
            int e, t;

            st = new StringTokenizer(br.readLine());

            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            list[i] = new Quest(e, t);
        }

        init();

        for(int i = 0; i<n; i++){
            for(int j = MAX_T; j>=0; j--){
                if(list[i].t<=j){
                    dp[j] = Math.max(dp[j], dp[j-list[i].t]+list[i].e);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<=MAX_T; i++){
            if(dp[i]>=m) ans = Math.min(ans, i);
        }

        if(ans == Integer.MAX_VALUE) ans = -1;

        System.out.print(ans);
    }
}