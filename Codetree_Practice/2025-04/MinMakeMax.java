//IL 4. lesson 04 - 순열 만들기 : 수들 중 최솟값 최대화하기
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] rowVisited;
    static boolean[] colVisited;
    static ArrayList<Integer> numList = new ArrayList<Integer>();

    static int answer = Integer.MIN_VALUE;

    public static void choose(int curr){
        if(curr == n){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<numList.size(); i++){
                min = Math.min(min, numList.get(i));
            }
            answer = Math.max(min, answer);
            return;
        }
        for(int i = 0; i<n; i++){
            if(rowVisited[curr] || colVisited[i]) continue;
            rowVisited[curr] = true;
            colVisited[i] = true;
            numList.add(grid[curr][i]);

            choose(curr+1);

            rowVisited[curr] = false;
            colVisited[i] = false;
            numList.remove(numList.size()-1);
        }
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
        System.out.print(answer);
    }
}