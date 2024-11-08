import java.util.*;
import java.lang.*;

public class pinball {
    /* 최대 시간 측정 */
    static int maxCount = 0;

    /* 방향 */
    static int[] dirX = {0, 0, -1, 1}; //Left Right Up Down
    static int[] dirY = {-1, 1, 0, 0}; //Left Right Up Down

    public static void move(int[][] grid, int r, int c, int dir){
        int tmpCount = 1;
        while(true){
            // System.out.println("row : "+r+" / col : "+c+" / dir : "+dir+" / count : "+tmpCount);
            if(r<0 || r>grid.length-1 || c<0 || c>grid[0].length-1){
                break;
            }
            if(grid[r][c]==0){
                r += dirX[dir];
                c += dirY[dir];
                tmpCount++;
            }
            else if(grid[r][c]==1){ // '/' 모양
                if(dir == 0){ // Left -> Down
                    dir = 3; // Down
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
                else if(dir == 1){ // Right -> Up
                    dir = 2; // Up
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
                else if(dir == 2){ // Up -> Right
                    dir = 1; // Right
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
                else if(dir == 3){ // Down -> Left
                    dir = 0; // Left
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
            }
            else if(grid[r][c]==2){ // '\' 모양
                if(dir == 0){ // Left -> Up
                    dir = 2; // Up
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
                else if(dir == 1){ // Right -> Down
                    dir = 3; // Down
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
                else if(dir == 2){ // Up -> Left
                    dir = 0; // Left
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
                else if(dir == 3){ // Down -> Right
                    dir = 1; // Right
                    r += dirX[dir];
                    c += dirY[dir];
                    tmpCount++;
                }
            }
        }
        // System.out.println("[END] row : "+r+"  / col : "+c+" / dir : "+dir+" / count : "+tmpCount);
        // System.out.println();
        // 최댓값 비교
        maxCount = Math.max(maxCount, tmpCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        // 진행 방향 설정해주는 변수 : Left - 0, Right - 1, Up - 2, Down - 3
        int dir = 0;

        // 최대 소요 시간을 찾기 위해 완전 탐색 진행
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == 0){ // 위쪽 줄에서 시작
                    dir = 3; // Down
                    move(grid, i, j, dir);
                }
                if(j == 0){ // 왼쪽 줄에서 시작
                    dir = 1; // Right
                    move(grid, i, j, dir);
                }
                if(j == n-1){ // 오른쪽 줄에서 시작
                    dir = 0; // Left
                    move(grid, i, j, dir);
                }
                if(i == n-1){ // 아래쪽 줄에서 시작
                    dir = 2; // Up
                    move(grid, i, j, dir);
                }
            }
        }
        System.out.print(maxCount);
    }
}