// 코드트리 IL - DFS : 뿌요뿌요
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int tmpBlockCount = 1;
    static int bamBlockNum = 0;
    static int maxBlockNum = 0;

    static int[] dirR = {0,0,1,-1};
    static int[] dirC = {1,-1,0,0};

    public static void DFS(int r, int c, int m){
        for(int i = 0; i<4; i++){
            int newR = r+dirR[i];
            int newC = c+dirC[i];
            if(canBam(newR, newC, m)){
                tmpBlockCount++;
                visited[newR][newC] = true;
                DFS(newR, newC, m);
            }
        }
    }

    public static boolean canBam(int r, int c, int m){
        return (r>=0 && r<n && c>=0 && c<n && grid[r][c] == m && !visited[r][c]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(!visited[i][j]){
                    tmpBlockCount = 1;
                    visited[i][j] = true;
                    DFS(i, j, grid[i][j]);
                    if(tmpBlockCount>=4) bamBlockNum ++;
                    maxBlockNum = Math.max(maxBlockNum, tmpBlockCount);
                }
            }
        }

        System.out.print(bamBlockNum+" "+maxBlockNum);
    }
}