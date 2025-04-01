//2025.04.01 / IL - BFS / 최소 경로로 탈출하기

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
    static int[][] step;
    static Queue<Point> q = new LinkedList<>();

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void BFS(){
        while(!q.isEmpty()){
            Point curr = q.poll();

            for(int i = 0; i<4; i++){
                int nextR = curr.r + dirR[i];
                int nextC = curr.c + dirC[i];

                if(canGo(nextR, nextC)){
                    visited[nextR][nextC] = true;
                    step[nextR][nextC] = step[curr.r][curr.c]+1;
                    q.offer(new Point(nextR, nextC));
                }
            }
        }
    }

    public static boolean canGo(int r, int c){
        return (r>=0 && r<n && c>=0 && c<m && !visited[r][c] && grid[r][c] == 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        step = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        step[n-1][m-1] = -1;

        q.offer(new Point(0,0));
        BFS();
        System.out.print(step[n-1][m-1]);
    }
}