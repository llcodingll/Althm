import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dirR = {0, 0, 1, -1};
    static int[] dirC = {1, -1, 0, 0};
    static ArrayList<Integer> population = new ArrayList<Integer>();
    static int tmpCount = 0;

    public static void DFS(int r, int c){
        for(int i = 0; i<4; i++){
            int newR = r+dirR[i];
            int newC = c+dirC[i];
            if(canGo(newR, newC)){
                tmpCount++;
                visited[newR][newC] = true;
                DFS(newR, newC);
            }
        }
    }

    public static boolean canGo(int r, int c){
        return (r>=0 && r<n && c>=0 && c<n && grid[r][c] != 0 && !visited[r][c]);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    tmpCount = 1;
                    visited[i][j] = true;
                    DFS(i, j);
                    population.add(tmpCount);
                }
            }
        }

        Collections.sort(population);
        System.out.println(population.size());

        for(int i = 0; i<population.size(); i++){
            System.out.println(population.get(i));
        }
    }
}