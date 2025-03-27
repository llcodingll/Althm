// 코드트리 IL - BFS : K번 최댓값으로 이동하기

import java.util.*;
import java.io.*;

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
    static int k;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static Point startPoint;
    static Point maxPoint;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void BFS(){
        maxPoint = null;
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            for(int i = 0; i<4; i++){
                int nextR = curr.r+dirR[i];
                int nextC = curr.c+dirC[i];

                if(canGo(nextR, nextC)){
                    visited[nextR][nextC] = true;
                    queue.offer(new Point(nextR, nextC));
                    if(maxPoint == null || grid[nextR][nextC] > grid[maxPoint.r][maxPoint.c]){
                        maxPoint = new Point(nextR, nextC);
                    }
                    else if(grid[nextR][nextC] == grid[maxPoint.r][maxPoint.c]){
                        if(nextR < maxPoint.r) maxPoint = new Point(nextR, nextC);
                        else if(nextR == maxPoint.r && nextC < maxPoint.c) maxPoint = new Point(nextR, nextC);
                    }
                }
            }
        }
    }

    public static boolean canGo(int r, int c){
        return (r>=0 && r<n && c>=0 && c<n && !visited[r][c] && grid[r][c]<grid[startPoint.r][startPoint.c]);
    }

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startPoint = new Point(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
        for(int i = 0; i<k; i++){
            queue.offer(startPoint);
            BFS();
            init();
            if(maxPoint != null) startPoint = new Point(maxPoint.r, maxPoint.c);
        }

        System.out.print((startPoint.r+1)+" "+(startPoint.c+1));
    }
}