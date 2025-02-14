import java.util.*;
import java.io.*;

class Jewel{
    int w;
    int v;

    public Jewel(int w, int v){
        this.w = w;
        this.v = v;
    }
}

public class Main {
    static int n;
    static int m;
    static Jewel[] jList;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        jList = new Jewel[n];
        dp = new int[m+1];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jList[i] = new Jewel(w, v);
        }

        for(int i = 0; i<=m; i++){
            for(int j = 0; j<n; j++){
                if(i>=jList[j].w) dp[i] = Math.max(dp[i], dp[i-jList[j].w]+jList[j].v);
            }
        }

        int ans = 0;
        for(int i = 0; i<=m; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}