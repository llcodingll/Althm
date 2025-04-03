
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_BfsDfs {

    static boolean[] visited, checked;
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        checked = new boolean[N + 1];

        adj = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(input.nextToken());
            int e = Integer.parseInt(input.nextToken());

            adj[s][e] = 1;
            adj[e][s] = 1;
        }

        dfs(start);
        System.out.println();
        bfs(start);
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                for (int i = N; i > 0; i--) {
                    if (!visited[i] && adj[curr][i] == 1) {
                        stack.push(i);
                    }
                }
                System.out.print(curr + " ");
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int curr = que.poll();
            if (!checked[curr]) {
                checked[curr] = true;
                for (int i = 1; i <= N; i++) {
                    if (!checked[i] && adj[curr][i] == 1) {
                        que.add(i);
                    }
                }
                System.out.print(curr + " ");
            }
        }
    }
}
