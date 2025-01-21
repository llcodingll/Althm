import java.util.*;
import java.lang.*;

public class positive_rectangle {
    /* 모든 grid를 돌며(완전탐색) 직사각형 왼쪽 상단 모서리 지점으로 정하고 maxRect() 호출 후 최대 크기를 반환하는 함수 */
    public static int setPointAndGetMax(int[][]grid){
        int max = -1;
        for(int row =0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                max = Math.max(max, maxRect(grid, row, col));
            }
        }
        return max;
    }

    /* 해당 지점에서의 모든 직사각형의 경우의 수를 비교하여, 직사각형의 최대 크기를 구하여 반환하는 함수 */
    public static int maxRect(int[][]grid, int row, int col){
        int tmpMax = -1;
        for(int i = row; i<grid.length; i++){
            for(int j = col; j<grid[i].length; j++){
                int size = 0; //직사각형의 크기
                boolean isInNegative = false; //직사각형 내부에 음수가 있는지 판별
                for(int x=row; x<=i; x++){
                    for(int y=col; y<=j; y++){
                        if(grid[x][y]>0){
                            size++;
                        }
                        else{
                            isInNegative = true;
                        }
                    }
                }
                if(!isInNegative){
                    tmpMax = Math.max(tmpMax, size);
                }
            }
        }
        return tmpMax;
    }

    public static void main(String[] args) {
        /* input 받기 */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print(setPointAndGetMax(grid));
    }
}