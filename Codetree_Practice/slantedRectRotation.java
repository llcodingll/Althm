import java.util.*;
public class slantedRectRotation {
    /* 반시계 방향 회전 */
    public static void counterClockWise(int r, int c, int[] m, int[][] grid){
        int tmp = grid[r][c]; // 처음 값 저장
        int[] row_direction = {1, 1, -1, -1}; // x방향 설정
        int[] col_direction = {-1, 1, 1, -1}; // y방향 설정
        for(int i = 3; i>=0; i--){ // 회전을 위해 반복 (순서 : 4-3-2-1)
            for(int j = 0; j<m[i]; j++){
                grid[r][c] = grid[r+row_direction[i]][c+col_direction[i]];
                r += row_direction[i];
                c += col_direction[i];
            }
            if(i==0){//마지막에 tmp 값을 올바른 자리에 되돌려 놓음
                r -= row_direction[i];
                c -= col_direction[i];
                grid[r][c] = tmp;
            }
        }
    }

    /* 시계 방향 회전 */
    public static void clockWise(int r, int c, int[] m, int[][] grid){
        int tmp = grid[r][c]; // 처음 값 저장
        int[] row_direction = {-1, -1, 1, 1}; // x방향 설정 (순서 : 1-2-3-4)
        int[] col_direction = {1, -1, -1, 1}; // y방향 설정 (순서 : 1-2-3-4)
        for(int i = 0; i<4; i++){ // 회전을 위해 반복 (순서 : 1-2-3-4)
            for(int j = 0; j<m[i]; j++){
                grid[r][c] = grid[r+row_direction[i]][c+col_direction[i]];
                r += row_direction[i];
                c += col_direction[i];
            }
            if(i==3){//마지막에 tmp 값을 올바른 자리에 되돌려 놓음
                r -= row_direction[i];
                c -= col_direction[i];
                grid[r][c] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        /* 입력값 받기 */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int[] m = new int[4];
        for(int i = 0; i<m.length; i++){
            m[i] = sc.nextInt();
        }
        int dir = sc.nextInt();

        /* 방향에 따라 다른 함수 호출 */
        if(dir==0){
            counterClockWise(r, c, m, grid);
        }
        else{
            clockWise(r, c, m, grid);
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}