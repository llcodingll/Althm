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

public class avoidRain {
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    static int[][] grid;
    static boolean[][] visited;
    static int[][] step;
    static Queue<Point> queue;
    static int[][] answer;

    public static void findPerson(){
        Point startPoint;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j]==2){
                    startPoint = new Point(i, j);
                    queue.add(startPoint);
                    visited[i][j] = true;
                    answer[i][j] = bfs();
                    init();
                }
            }
        }
    }

    public static int bfs(){
        int minNum = -1;
        while(!queue.isEmpty()){
            Point currPoint = queue.poll();
            int currNum = step[currPoint.r][currPoint.c];

            for(int i = 0; i<4; i++){
                int nextR = currPoint.r+dirR[i];
                int nextC = currPoint.c+dirC[i];

                if(canGo(nextR, nextC)){
                    visited[nextR][nextC] = true;
                    step[nextR][nextC] = currNum+1;
                    if(grid[nextR][nextC]==3){
                        minNum = step[nextR][nextC];
                        queue.clear();
                        return minNum;
                    }
                    queue.add(new Point(nextR, nextC));
                }
            }
        }
        return minNum;
    }

    public static boolean canGo(int r, int c){
        if(!isRange(r, c)) return false;
        if(visited[r][c] || grid[r][c]==1) return false;
        return true;
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<grid.length && c>=0 && c<grid.length);
    }

    public static void init(){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                visited[i][j] = false;
                step[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        step = new int[n][n];
        queue = new LinkedList<>();
        answer = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findPerson();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }

    }
}
