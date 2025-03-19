import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int vertexNum = 0;

    public static void DFS(int vertex){
        for(int i = 0; i<graph[vertex].size(); i++){
            int currV = graph[vertex].get(i);
            if(!visited[currV]){
                vertexNum++;
                visited[currV] = true;
                DFS(currV);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        visited[1] = true;

        for(int i = 0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        DFS(1);
        System.out.println(vertexNum);
    }
}
