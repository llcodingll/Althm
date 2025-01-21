import java.util.*;

public class moveBiggerNumSameTime {
    /* 방향을 나타내는 전역 변수 : 상 하 좌 우 */
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    /* 격자를 완전 탐색하며 구슬을 찾아 모두 이동시키고 지우는 메서드 */
    public static void moveAllMarble(int[][] grid, int[][] count, int[][] nextCount){
        // 격자 완전 탐색하며 구슬 찾기
        for(int i = 0; i<count.length; i++){
            for(int j = 0; j<count.length; j++){
                if(count[i][j]==1){
                    moveBigger(grid, nextCount, i, j);
                }
            }
        }

        // count에 nextCount 덮어 씌우기
        copyGrid(count, nextCount);

        // 충돌이 일어난 구슬 지우기
        removeConflictMarble(count);

        // nextCount 초기화
        initGrid(nextCount);
    }

    /* 상하좌우 순서로 탐색하여 가장 큰 숫자로 이동하는 메서드 */
    public static void moveBigger(int[][] grid, int[][] nextCount, int row, int col){
        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i<4; i++){
            if(row+dirX[i]>=0 && row+dirX[i]<=grid.length-1 && col+dirY[i]>=0 && col+dirY[i]<=grid.length-1){
                if(max<grid[row+dirX[i]][col+dirY[i]]){
                    max = grid[row+dirX[i]][col+dirY[i]];
                    maxIdx = i;
                }
            }
        }
        nextCount[row+dirX[maxIdx]][col+dirY[maxIdx]] += 1;
    }

    /* 충돌이 일어난 구슬을 모두 지우는 메서드 */
    public static void removeConflictMarble(int[][] count){
        for(int i = 0; i<count.length; i++){
            for(int j = 0; j<count.length; j++){
                if(count[i][j]>=2){
                    count[i][j] = 0;
                }
            }
        }
    }

    /* 2차원 배열(격자) 덮어 씌우는 메서드 */
    public static void copyGrid(int[][] grid, int[][] nextGrid){
        // grid에 nextGrid 덮어 씌우기
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    /* 2차원 배열(격자) 초기화 메서드 */
    public static void initGrid(int[][] grid){
        // grid 값 모두 0으로 만들기
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){
                grid[i][j] = 0;
            }
        }
    }

    /* 구슬 수 세는 메서드 */
    public static int countMarble(int[][] count){
        int marbleCount = 0;
        for(int i = 0; i<count.length; i++){
            for(int j = 0; j<count.length; j++){
                if(count[i][j] == 1){
                    marbleCount++;
                }
            }
        }
        return marbleCount;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int[][] grid = new int[n][n];
        int[][] count = new int[n][n];
        int[][] nextCount = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int row = 0;
        int col = 0;
        for(int i = 0; i<m; i++){
            row = sc.nextInt()-1;
            col = sc.nextInt()-1;
            count[row][col] = 1;
        }

        // t초 만큼 구슬 이동
        for(int i = 0; i<t; i++){
            moveAllMarble(grid, count, nextCount);
        }

        //구슬 수 세기
        int result = countMarble(count);
        System.out.println(result);
        
    }
}