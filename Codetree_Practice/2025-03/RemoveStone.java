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
    static int m;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    static int[][] grid;
    static boolean[][] visited;
    static Point[] pointList;
    static Queue<Point> queue = new LinkedList<>();

    static int tmpCount = 0;
    static int maxCount = 0;

    public static void search(int count){
        if(count == m){
            tmpCount = 0;
            for(Point p : pointList){
                if(!visited[p.r][p.c]){
                    tmpCount++;
                    visited[p.r][p.c] = true;
                    queue.offer(new Point(p.r, p.c));
                    BFS();
                }
            }
            maxCount = Math.max(maxCount, tmpCount);
            init();
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    search(count+1);
                    grid[i][j] = 1;
                }
            }
        }
    }

    public static void BFS(){
        while(!queue.isEmpty()){
            Point curr = queue.poll();

            for(int i = 0; i<4; i++){
                int nextR = curr.r + dirR[i];
                int nextC = curr.c + dirC[i];

                if(canGo(nextR, nextC)){
                    tmpCount++;
                    visited[nextR][nextC] = true;
                    queue.offer(new Point(nextR, nextC));
                }
            }
        }
    }

    public static boolean canGo(int r, int c){
        return (r>=0 && r<n && c>=0 && c<n && !visited[r][c] && grid[r][c]==0);
    }

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        pointList = new Point[k];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            pointList[i] = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }

        search(0);

        System.out.println(maxCount);
    }
}