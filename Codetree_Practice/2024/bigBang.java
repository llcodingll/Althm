import java.util.*;
import java.lang.*;

public class bigBang {
    /* 십자 모양으로 폭탄을 늘리는 메서드 */
    public static void crossBang(boolean[][] grid, int t, int r, int c){
        // 폭발하는 범위
        int bangRange = (int) Math.pow(2, t-1);
        // 가로 방향 폭발
        for(int i = c-bangRange; i<=c+bangRange; i+=bangRange){
            if(i>=0 && i<=grid.length-1 && !grid[r][i]){ // 격자 범위를 벗어나지 않으면서, 폭탄이 놓여있지 않은 경우
                grid[r][i] = true;
            }
        }
        // 세로 방향 폭발
        for(int i = r-bangRange; i<=r+bangRange; i+=bangRange){
            if(i>=0 && i<=grid.length-1 && !grid[i][c]){ // 폭탄이 놓여있지 않은 경우
                grid[i][c] = true;
            }
        }
    }

    /* 2차원 배열의 값을 복사하여 넣어주는 메서드 */
    public static void arrayCopy(boolean[][] grid, boolean[][] tmpGrid){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                grid[i][j] = tmpGrid[i][j];
            }
        }
    }

    public static void main(String[] args) {
        // 입력값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;

        boolean[][] grid = new boolean[n][n]; // 격자 - 폭탄이 있으면 true로 표시하는 2차원 배열
        boolean[][] nextGrid = new boolean[n][n]; // 임시로 폭탄의 위치를 저장하는 배열
        grid[r][c] = true; // 첫번째 폭탄
        nextGrid[r][c] = true; // 첫번째 폭탄

        for(int t = 1; t<=m; t++){
            for(int i = 0; i<grid.length; i++){
                for(int j = 0; j<grid[0].length; j++){
                    if(grid[i][j]){
                        crossBang(nextGrid, t, i, j);
                    }
                }
            }
            arrayCopy(grid, nextGrid);
        }

        // 모든 폭발 이후 폭탄 개수를 셈
        int countBomb = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]){
                    countBomb++;
                }
            }
        }
        System.out.print(countBomb);
    }
}