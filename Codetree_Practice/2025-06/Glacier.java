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
    static int[][] glacier;
    static boolean[][] visited;
    static boolean[][] beMelt;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    static int t = 0;
    static int lastGlacierNum = 0;

    public static boolean isAllMelt(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(glacier[i][j]==1) return false;
            }
        }
        return true;
    }

    public static void BFS(){
        while(!queue.isEmpty()){
            Point curr = queue.poll();

            int r = curr.r;
            int c = curr.c;

            for(int i = 0; i<4; i++){
                int nextR = r+dirR[i];
                int nextC = c+dirC[i];

                if(isWater(nextR, nextC)){
                    visited[nextR][nextC] = true;
                    queue.offer(new Point(nextR, nextC));
                }
            }
        }
    }

    public static boolean isWater(int r, int c){
        if(r<0 || r>=n || c<0 || c>=m) return false;
        if(glacier[r][c] == 1){
            beMelt[r][c] = true; // 물에 닿아있는 빙하 체크
            return false;
        }
        if(visited[r][c]) return false;
        else return true;
    }

    public static void melt(){
        lastGlacierNum = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(beMelt[i][j]){
                    glacier[i][j] = 0;
                    lastGlacierNum++;
                }
            }
        }
    }

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                beMelt[i][j] = false;
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        glacier = new int[n][m];
        visited = new boolean[n][m];
        beMelt = new boolean[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                glacier[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!isAllMelt()){
            t++;
            visited[0][0] = true;
            queue.offer(new Point(0, 0));
            BFS();
            melt();
            init();
        }

        System.out.println(t+" "+lastGlacierNum);
    }
}