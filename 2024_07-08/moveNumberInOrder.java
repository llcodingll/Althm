import java.util.*;
import java.lang.*;

public class moveNumberInOrder {
    /* 방향을 나타내는 변수 - 순서 : 왼쪽상단, 상단, 오른쪽상단, 왼쪽, 오른쪽, 왼쪽하단, 아래쪽, 오른쪽하단 */
    static int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

    /* 격자 전체를 숫자 순서대로 돌며 이동시키는 메서드 */
    public static void turn(int n, int[][] grid){
        int curX = 0;
        int curY = 0;

        // 숫자를 키움 (1~n*n)
        for(int num = 1; num<=Math.pow(n, 2); num++){
            // grid를 탐색하여 1부터 n*n까지 순서대로 어느 위치에 있는지 탐색
            for(int x = 0; x<n; x++){
                for(int y = 0; y<n; y++){
                    if(grid[x][y] == num){
                        curX = x;
                        curY = y;
                    }
                }
            }
            // 숫자를 찾으면, 그 숫자 주위를 탐색해서 최대인 숫자와 교환함
            swapMax(n, grid, curX, curY);
        }
        
    }

    /* 인접 칸 중 최대 숫자와 중앙 숫자를 교환하는 메서드 */
    public static void swapMax(int n, int[][] grid, int x, int y){
        int maxIdx = 0;
        int maxValue = 0;
        for(int i = 0; i<8; i++){
            if(x+dirX[i]>=0 && x+dirX[i]<=n-1 && y+dirY[i]>=0 && y+dirY[i]<=n-1){
                if(maxValue<grid[x+dirX[i]][y+dirY[i]]){
                    maxValue = grid[x+dirX[i]][y+dirY[i]];
                    maxIdx = i;
                }
            }
        }
        grid[x+dirX[maxIdx]][y+dirY[maxIdx]] = grid[x][y];
        grid[x][y] = maxValue;
    }

    public static void main(String[] args) {
        // 사용자 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
        // m번의 턴을 거침
        for(int i = 0; i<m; i++){
            turn(n, grid);
        }

        // 결과 출력
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

    }
}

