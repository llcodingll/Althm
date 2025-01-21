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

public class spoiledOrange {
    static int[] dirR = {-1,1,0,0};
    static int[] dirC = {0,0,-1,1};

    static int n;
    static int k;

    static int[][] grid;
    static boolean[][] isSpoiled;
    static int[][] step;
    static Queue<Point> queue;

    public static void findSpoiledOrange(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.add(new Point(i, j));
                    isSpoiled[i][j] = true;
                }
            }
        }
        bfs();
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Point currPoint = queue.poll();
            int currR = currPoint.r;
            int currC = currPoint.c;
            int currStep = step[currR][currC];

            for(int i = 0 ; i<4; i++){
                int nextR = currR+dirR[i];
                int nextC = currC+dirC[i];

                if(canSpoil(nextR, nextC)){
                    isSpoiled[nextR][nextC] = true;
                    step[nextR][nextC] = currStep+1;
                    queue.add(new Point(nextR, nextC));
                }
            }
        }
    }

    public static boolean canSpoil(int r, int c){
        if(r<0 || r>=n || c<0 || c>=n) return false;
        if(grid[r][c]==0 || isSpoiled[r][c]) return false;
        return true;
    }

    public static void fillStep(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(step[i][j] == 0){
                    if(grid[i][j] == 0) step[i][j] = -1;
                    if(grid[i][j] == 1) step[i][j] = -2;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        isSpoiled = new boolean[n][n];
        step = new int[n][n];
        queue = new LinkedList<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findSpoiledOrange();
        fillStep();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(step[i][j]+" ");
            }
            System.out.println();
        }
    }
}
