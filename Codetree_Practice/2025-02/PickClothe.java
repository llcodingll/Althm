import java.util.*;
import java.io.*;

class Clothe{
    int s;
    int e;
    int v;

    public Clothe(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }
}

public class Main {
    static int n;
    static int m;
    static Clothe[] list;
    static int[][] dp; //dp[i][j] : i번째 날에 j번째 옷을 입었을 경우 가능한 만족도 최대 합

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new Clothe[n+1];
        dp = new int[m+1][n+1];

        for(int i = 1; i<=n; i++){
            int s, e, v;
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            list[i] = new Clothe(s, e, v);
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    if(i+1>=list[j].s && i+1<=list[j].e && i>=list[k].s && i<=list[k].e){
                        int diff = Math.abs(list[k].v - list[j].v);
                        dp[i+1][j] = Math.max(dp[i+1][j], dp[i][k]+diff);
                    }
                }
            }
        }

        int ans = 0;
        for(int i =0; i<=n; i++){
            ans = Math.max(ans, dp[m][i]);
        }

        System.out.print(ans);
    }
}