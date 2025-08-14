import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static int maxK = 1;
    static int maxNum = 0;

    static int[] dirR = {0, 0, -1, 1};
    static int[] dirC = {-1, 1, 0, 0};

    public static void DFS(int r, int c, int k){
        for(int i = 0; i<4; i++){
            int newR = r + dirR[i];
            int newC = c + dirC[i];
            if(canGo(newR, newC, k)){
                visited[newR][newC] = true;
                DFS(newR, newC, k);
            }
        }
    }

    public static boolean canGo(int r, int c, int k){
        return (r>=0 && r<n && c>=0 && c<m && !visited[r][c] && grid[r][c]>k);
    }

    public static void init(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k<=100; k++){
            int tmpCount = 0;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(!visited[i][j] && grid[i][j]>k){
                        visited[i][j] = true;
                        DFS(i, j, k);
                        tmpCount++;
                    }
                }
            }
            if(tmpCount==0){
                break;
            }
            else{
                init();
                if(tmpCount>maxNum){
                    maxK = k;
                    maxNum = tmpCount;
                }
            }
        }

        System.out.print(maxK+" "+maxNum);
    }
}