import java.io.*;
import java.util.*;

class Point{
    int r;
    int c;

    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dirR = {0, 0, -1, 1};
    static int[] dirC = {-1, 1, 0, 0};

    static int answer = 0;

    public static void BFS(){
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            int r = curr.r;
            int c = curr.c;
            if(r == n-1 && c == m-1) answer = 1;

            for(int i = 0; i<4; i++){
                int nextR = r+dirR[i];
                int nextC = c+dirC[i];
                if(canGo(nextR, nextC)){
                    visited[nextR][nextC] = true;
                    queue.offer(new Point(nextR, nextC));
                }
            }
        }
    }

    public static boolean canGo(int r, int c){
        return (r>=0 && r<n && c>=0 && c<m && grid[r][c] == 1 && !visited[r][c]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        queue.offer(new Point(0, 0));
        BFS();

        System.out.print(answer);
    }
}