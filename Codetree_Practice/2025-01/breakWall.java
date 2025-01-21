import java.util.*;
import java.io.*;

class Point {
    int r;
    int c;

    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class breakWall {
    static int n;
    static int k;

    static int[][] grid;
    static boolean[][] visited;
    static int[][] step;
    static Queue<Point> queue = new LinkedList<>();
    static ArrayList<Point> list = new ArrayList<>();

    static Point startPoint;
    static Point endPoint;

    static int answer = -1;

    static int[] dirR = {-1,1,0,0};
    static int[] dirC = {0,0,-1,1};

    public static void findWall(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    list.add(new Point(i, j));
                }
            }
        }
    }

    public static void chooseWall(int wallNum, int cnt){
        if(wallNum == list.size()){
            if(cnt == k){
                visited[startPoint.r][startPoint.c] = true;
                queue.add(startPoint);
                bfs();
                init();
            }
            return ;
        }
        Point currPoint = list.get(wallNum);

        grid[currPoint.r][currPoint.c] = 0;
        chooseWall(wallNum+1, cnt+1);
        grid[currPoint.r][currPoint.c] = 1;

        chooseWall(wallNum+1, cnt);
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Point currPoint = queue.poll();
            int currNum = step[currPoint.r][currPoint.c];

            if(currPoint.r == endPoint.r && currPoint.c == endPoint.c){
                if(answer<0 || answer>currNum){
                    answer = currNum;
                }
            }

            for(int i = 0; i<4; i++){
                int newR = currPoint.r+dirR[i];
                int newC = currPoint.c+dirC[i];

                if(canGo(newR, newC)){
                    visited[newR][newC] = true;
                    step[newR][newC] = currNum+1;
                    queue.add(new Point(newR, newC));
                }
            }
        }
    }

    public static boolean canGo(int r, int c){
        if(r<0 || r>=n || c<0 || c>=n) return false;
        if(visited[r][c] || grid[r][c] == 1) return false;
        return true;
    }

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                visited[i][j] = false;
                step[i][j] = 0;
            }
        }
        queue.clear();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        step = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken())-1;
        int c1 = Integer.parseInt(st.nextToken())-1;
        startPoint = new Point(r1, c1);

        st = new StringTokenizer(br.readLine());
        int r2 = Integer.parseInt(st.nextToken())-1;
        int c2 = Integer.parseInt(st.nextToken())-1;
        endPoint = new Point(r2, c2);

        findWall();
        chooseWall(0, 0);
        System.out.print(answer);
    }
}