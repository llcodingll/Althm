//IL 4. lesson 04 - 순열 만들기 : 수들의 합 최대화하기
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] rowVisited;
    static boolean[] colVisited;
    static ArrayList<Integer> number = new ArrayList<>();
    static int max = 0;
    public static void choose(int curr){
        if(curr == n){
            int tmp = 0;
            for(int i = 0; i<number.size(); i++){
                tmp += number.get(i);
            }
            max = Math.max(max, tmp);
            return;
        }
        for(int i = 0; i<n; i++){
            if(rowVisited[curr] || colVisited[i]) continue;
            rowVisited[curr] = true;
            colVisited[i] = true;
            number.add(grid[curr][i]);

            choose(curr+1);

            rowVisited[curr] = false;
            colVisited[i] = false;
            number.remove(number.size()-1);
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        rowVisited = new boolean[n];
        colVisited = new boolean[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(0);

        System.out.print(max);
    }
}