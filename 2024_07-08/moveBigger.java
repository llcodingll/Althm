import java.util.*;

public class moveBigger {
    /* 좌표를 전역변수로 선언 */
    static int r = 0;
    static int c = 0;

    /* 상하좌우로 돌면서 본인 좌표값보다 큰 값을 찾고 위치를 갱신하는 메서드*/
    public static boolean moveToBigger(int[][] grid, boolean isMove){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for(int i = 0; i<4; i++){
            if(r+dy[i]>=0 && r+dy[i]<grid.length && c+dx[i]>=0 && c+dx[i]<grid[0].length){
                if(grid[r][c]<grid[r+dy[i]][c+dx[i]]){
                    r = r+dy[i];
                    c = c+dx[i];
                    isMove = true; //위치 갱신(이동)이 일어났음을 표시
                    break;
                }
            }
        }
        return isMove;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        boolean isMove;
        ArrayList<Integer> visited = new ArrayList<>();

        do{
            isMove = false;
            visited.add(grid[r][c]);
            isMove = moveToBigger(grid, isMove);
        }while(isMove);

        for(int num : visited){
            System.out.print(num+" ");
        }
    }
}