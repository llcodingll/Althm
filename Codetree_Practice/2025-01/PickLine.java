import java.io.*;
import java.util.*;
import java.lang.*;

class Line implements Comparable<Line>{
    int start;
    int end;

    public Line(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Line l){
        return this.start - l.start;
    }
}

public class PickLine {
    static int n;
    static Line[] lines;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        lines = new Line[n];
        dp = new int[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines[i] = new Line(start, end);
        }

        Arrays.sort(lines, 0, n);

        for(int i = 0; i<n; i++){
            dp[i] = 1;

            for(int j = 0; j<i; j++){
                if(lines[j].end < lines[i].start) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int ans = 0;

        for(int i = 0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}