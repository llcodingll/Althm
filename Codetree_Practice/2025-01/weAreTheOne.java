import java.util.*;
import java.lang.*;
import java.io.*;

class Point{
    int r;
    int c;

    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }

    public void setPoint(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class weAreTheOne {
    static int n;
    static int k;
    static int u;
    static int d;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int count;
    static ArrayList<Integer> list;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void findCase(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j]){
                    count = 1;
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                    bfs();
                    list.add(count);
                }
            }
        }
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Point currPoint = queue.poll();

            for(int i = 0; i<4; i++){
                int new_r = currPoint.r + dr[i];
                int new_c = currPoint.c + dc[i];
                Point newPoint = new Point(new_r, new_c);

                if(canGo(currPoint, newPoint)){
                    count++;
                    visited[newPoint.r][newPoint.c] = true;
                    queue.add(newPoint);
                }
            }
        }
    }

    public static boolean canGo(Point currPoint, Point newPoint){
        if(!isInGrid(newPoint.r, newPoint.c)) return false;
        if(visited[newPoint.r][newPoint.c]) return false;
        if(!isRange(currPoint, newPoint)) return false;
        return true;
    }

    public static boolean isInGrid(int r, int c){
        return (r>=0 && r<n && c>=0 && c<n);
    }

    public static boolean isRange(Point currPoint, Point newPoint){
        int diff = Math.abs(grid[currPoint.r][currPoint.c]-grid[newPoint.r][newPoint.c]);
        return diff>=u && diff<=d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        queue = new LinkedList<>();
        list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findCase();

        list.sort(Comparator.reverseOrder());

        for(int i = 0; i<k; i++){
            answer+=list.get(i);
        }

        System.out.println(answer);
    }
}