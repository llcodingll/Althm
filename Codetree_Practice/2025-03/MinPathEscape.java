import java.util.*;
import java.io.*;

class Vertex{
    int r;
    int c;

    public Vertex(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] isVisited;
    static int[][] step;
    static int currNum = 0;
    static int answer = -1;
    static Queue<Vertex> queue;

    public static void findWay(int r, int c){
        while(!queue.isEmpty()){
            Vertex curr = queue.poll();
            currNum = step[curr.r][curr.c];

            for(int i = 0; i<4; i++){
                int new_r = curr.r + dr[i];
                int new_c = curr.c + dc[i];
                if(canGo(new_r, new_c)){
                    isVisited[new_r][new_c] = true;
                    step[new_r][new_c] = currNum+1;
                    queue.add(new Vertex(new_r, new_c));
                }
            }
        }
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<n && c>=0 && c<m);
    }

    public static boolean canGo(int r, int c){
        if(!isRange(r, c)) return false;
        if(grid[r][c]==0 || isVisited[r][c]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        isVisited = new boolean[n][m];
        step = new int[n][m];
        queue = new LinkedList<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited[0][0] = true;
        queue.add(new Vertex(0, 0));
        findWay(0, 0);

        if(isVisited[n-1][m-1]) answer = step[n-1][m-1];

        System.out.println(answer);
    }
}