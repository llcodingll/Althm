import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static int answer = 0;

    static int[] dirR = {0, 1};
    static int[] dirC = {1, 0};

    public static void DFS(int r, int c){
        if(r == n-1 && c == m-1){
            answer = 1;
            return;
        }
        for(int i = 0; i<2; i++){
            int newR = r + dirR[i];
            int newC = c + dirC[i];
            if(canGo(newR, newC)){
                visited[newR][newC] = true;
                DFS(newR, newC);
            }
        }
    }

    public static boolean canGo(int r, int c){
        return (r>=0 && r<n && c>=0 && c<m && grid[r][c] != 0 && !visited[r][c]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;
        DFS(0,0);

        System.out.println(answer);
    }
}