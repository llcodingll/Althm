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

    static int[] dr = {-2, -1, -2, -1, 2, 1, 2, 1};
    static int[] dc = {-1, -2, 1, 2, -1, -2, 1, 2};

    static int n;
    static Vertex startV;
    static Vertex endV;
    static boolean[][] isVisited;
    static int[][] step;
    static int currNum = 0;
    static int answer = -1;
    static Queue<Vertex> queue;

    public static void findWay(int r, int c){
        while(!queue.isEmpty()){
            Vertex curr = queue.poll();
            currNum = step[curr.r][curr.c];

            if(isEnd(curr.r, curr.c)){
                if(answer<0 || (answer>0 && answer>currNum)) answer = currNum;
            }

            for(int i = 0; i<8; i++){
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
        return (r>=0 && r<n && c>=0 && c<n);
    }

    public static boolean canGo(int r, int c){
        if(!isRange(r, c)) return false;
        if(isVisited[r][c]) return false;
        return true;
    }

    public static boolean isEnd(int r, int c){
        return (r == endV.r && c == endV.c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken())-1;
        int startC = Integer.parseInt(st.nextToken())-1;
        int endR = Integer.parseInt(st.nextToken())-1;
        int endC = Integer.parseInt(st.nextToken())-1;

        startV = new Vertex(startR, startC);
        endV = new Vertex(endR, endC);

        isVisited = new boolean[n][n];
        step = new int[n][n];
        queue = new LinkedList<>();

        isVisited[startR][startC] = true;
        queue.add(startV);
        findWay(0, 0);

        System.out.println(answer);
    }
}