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
    static int k;
    static int[][] grid;
    static boolean[][] visited;
    static Point[] pointList;
    static Queue<Point> queue = new LinkedList<>();
    static int count = 0;

    static int[] dirR = {0, 0, -1, 1};
    static int[] dirC = {-1, 1, 0, 0};

    public static void BFS(){
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            int r = curr.r;
            int c = curr.c;

            for(int i = 0; i<4; i++){
                int nextR = r+dirR[i];
                int nextC = c+dirC[i];
                if(canGo(nextR, nextC)){
                    visited[nextR][nextC] = true;
                    count++;
                    queue.offer(new Point(nextR, nextC));
                }
            }
        }
    }

    public static boolean canGo(int r, int c){
        return (r>=0 && r<n && c>=0 && c<n && grid[r][c] == 0 && !visited[r][c]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new boolean[n][n];
        pointList = new Point[k];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            pointList[i] = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }

        for(int i = 0; i<k; i++){
            if(!visited[pointList[i].r][pointList[i].c]){
                visited[pointList[i].r][pointList[i].c] = true;
                count++;
                queue.offer(pointList[i]);
                BFS();
            }
        }

        System.out.print(count);
    }
}