// IL - BFS : 빙하
import java.util.*;
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

public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static boolean[][] beMelt;
    static Queue<Point> queue;

    static int t = 0;
    static int lastIceNum = 0;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void find(){
        while(!queue.isEmpty()){
            Point curr = queue.poll();

            for(int i = 0; i<4; i++){
                int new_r = curr.r + dr[i];
                int new_c = curr.c + dc[i];
                if(canGo(new_r, new_c)){
                    visited[new_r][new_c] = true;
                    queue.add(new Point(new_r, new_c));
                }
            }
        }
    }

    public static void findAll(){
        while(!isAllMelt()){
            t++;
            lastIceNum = 0;
            visited[0][0] = true;
            queue.add(new Point(0, 0));
            find();
            melt();
            init();
        }
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<n && c>=0 && c<m);
    }

    public static boolean canGo(int r, int c){
        if(!isRange(r, c)) return false;
        if(visited[r][c]) return false;
        if(grid[r][c]==1){
            if(!beMelt[r][c]) beMelt[r][c] = true;
            return false;
        }
        return true;
    }

    public static void melt(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(beMelt[i][j]){
                    grid[i][j] = 0;
                    lastIceNum++;
                }
            }
        }
    }

    public static boolean isAllMelt(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                visited[i][j] = false;
                beMelt[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        beMelt = new boolean[n][m];
        queue = new LinkedList<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findAll();
        System.out.println(t+" "+lastIceNum);
    }
}