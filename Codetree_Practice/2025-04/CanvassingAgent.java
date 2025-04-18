//IL 4. lesson 04 - 순열 만들기 : 외판원 순회
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static ArrayList<Integer> seq = new ArrayList<Integer>();
    static int answer = Integer.MAX_VALUE;

    public static void choose(int curr){
        if(curr == n+1){
            seq.add(1);
            answer = Math.min(caculateSum(), answer);
            seq.remove(seq.size()-1);

            return;
        }

        for(int i = 2; i<=n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            seq.add(i);

            choose(curr+1);

            visited[i] = false;
            seq.remove(seq.size()-1);
        }
        return;
    }

    public static int caculateSum(){
        int sum = 0;
        for(int i = 0; i<n; i++){
            if(graph[seq.get(i)][seq.get(i+1)] == 0) return Integer.MAX_VALUE;
            sum += graph[seq.get(i)][seq.get(i+1)];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        seq.add(1);
        visited[1] = true;

        choose(2);
        System.out.print(answer);
    }
}