import java.util.*;
import java.io.*;

class Job implements Comparable<Job> {
    int startDay;
    int endDay;
    int pay;

    public Job(int startDay, int endDay, int pay){
        this.startDay = startDay;
        this.endDay = endDay;
        this.pay = pay;
    }

    @Override
    public int compareTo(Job o){
        if(this.endDay < o.endDay) return -1;
        if(this.endDay == o.endDay) return 0;
        else return 1;
    }
}

public class ToBeRich {
    static int n;
    static ArrayList<Job> jobList;
    static int[] dp;

    public static void init(){
        for(int i = 0; i<n; i++){
            dp[i] = jobList.get(i).pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        jobList = new ArrayList<>();
        dp = new int[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int startDay = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            jobList.add(new Job(startDay, endDay, pay));
        }

        Collections.sort(jobList);
        init();

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(jobList.get(i).endDay<jobList.get(j).startDay){
                    dp[j] = Math.max(dp[j], dp[i]+jobList.get(j).pay);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i<n; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}