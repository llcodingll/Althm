import java.util.*;

public class snakeLoveApple {
    /* 뱀의 이동 방향 관련 변수 */
    static int[] dirX = {-1, 1, 0, 0}; //U D R L
    static int[] dirY = {0, 0, 1, -1}; //U D R L

    /* 뱀의 머리 좌표 */
    static int headX = 0;
    static int headY = 0;

    /* 뱀의 꼬리 좌표 */
    static int tailX = 0;
    static int tailY = 0;

    /* 걸린 시간 */
    static int count = 0;

    /* 사과 순서 세기 */
    static int appleCount = 0;

    /* 뱀이 1칸 움직이는 메서드 */
    public static boolean move(int[][] grid, int appleX, int appleY, int dir){
        boolean stop =false; // 뱀이 이동할 수 없는 상황이 되면 true

        int nextHeadX = headX + dirX[dir];
        int nextHeadY = headY + dirY[dir];

        // 머리가 격자 밖으로 벗어난 경우
        if(nextHeadX<0 || nextHeadX>grid.length-1 || nextHeadY<0 || nextHeadY>grid.length-1){
            count++;
            stop = true;
        }
        // 머리가 몸과 닿은 경우
        else if(grid[nextHeadX][nextHeadY]>=1){
            count++;
            stop = true;
        }
        // 머리가 사과와 닿은 경우
        else if(nextHeadX==appleX && nextHeadY==appleY){
            count++;
            appleCount++;
            grid[nextHeadX][nextHeadY] = 5;
            switch(dir){
                case 0: //UP
                    grid[headX][headY] = 1;
                    break;
                case 1: //DOWN
                    grid[headX][headY] = 2;
                    break;
                case 2: //RIGHT
                    grid[headX][headY] = 3;
                    break;
                case 3: //LEFT
                    grid[headX][headY] = 4;
                    break;
            }
            headX = nextHeadX;
            headY = nextHeadY;
        }
        // 그냥 이동하는 경우
        else{
            count++;
            grid[nextHeadX][nextHeadY] = 5;
            switch(dir){
                case 0: //UP
                    grid[headX][headY] = 1;
                    break;
                case 1: //DOWN
                    grid[headX][headY] = 2;
                    break;
                case 2: //RIGHT
                    grid[headX][headY] = 3;
                    break;
                case 3: //LEFT
                    grid[headX][headY] = 4;
                    break;
            }
            headX = nextHeadX;
            headY = nextHeadY;
            switch(grid[tailX][tailY]-1){
                case 0: //UP
                    grid[tailX][tailY] = 0;
                    tailX += dirX[0];
                    tailY += dirY[0];
                    break;
                case 1: //DOWN
                    grid[tailX][tailY] = 0;
                    tailX += dirX[1];
                    tailY += dirY[1];
                    break;
                case 2: //RIGHT
                    grid[tailX][tailY] = 0;
                    tailX += dirX[2];
                    tailY += dirY[2];
                    break;
                case 3: //LEFT
                    grid[tailX][tailY] = 0;
                    tailX += dirX[3];
                    tailY += dirY[3];
                    break;
            }
        }
        return stop;
    }

    public static void main(String[] args){
        /* 입력값 받기 */
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] grid = new int[n][n]; // 뱀 머리 : 5, 뱀 몸 : 1(U) 2(D) 3(R) 4(L) (방향)
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        // 사과 위치 관련
        int [] appleX = new int[m];
        int [] appleY = new int[m]; 
        for(int i = 0; i<m; i++){
            appleX[i] = sc.nextInt()-1; // x좌표
            appleY[i] = sc.nextInt()-1; // y좌표
        }

        // 뱀 이동 관련
        int[] dir = new int[k]; // 방향 : 0(U), 1(D), 2(R), 3(L)
        int[] dx = new int[k]; // 이동 거리
        for(int i = 0; i<k; i++){
            switch(sc.next()){
                case "U":
                    dir[i] = 0;
                    break;
                case "D":
                    dir[i] = 1;
                    break;
                case "R":
                    dir[i] = 2;
                    break;
                case "L":
                    dir[i] = 3;
                    break;
            }
            dx[i] = sc.nextInt();
        }

        // 뱀을 이동 시킴
        boolean stop = false;
        for(int i = 0; i<k; i++){
            if(stop){
                break;
            }
            else{
                if(appleCount<m){
                    for(int j = 0; j<dx[i]; j++){
                        stop = move(grid, appleX[appleCount], appleY[appleCount], dir[i]);
                    }
                }
                else{
                    for(int j = 0; j<dx[i]; j++){
                        stop = move(grid, -1, -1, dir[i]);
                    }
                }
            }
        }

        System.out.print(count);
    }
}