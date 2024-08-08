import java.util.*;

public class Main {
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

    /* 뱀이 1칸 움직이는 메서드 */
    public static boolean move(int[][] grid, int dir){
        boolean stop =false; // 뱀이 이동할 수 없는 상황이 되면 true

        int nextHeadX = headX + dirX[dir];
        int nextHeadY = headY + dirY[dir];

        int tailDir = (grid[tailX][tailY] < 1 || grid[tailX][tailY] > 4) ? dir : grid[tailX][tailY]-1;
        int nextTailX = tailX + dirX[tailDir];
        int nextTailY = tailY + dirY[tailDir];
        
        // 머리가 격자 밖으로 벗어난 경우
        if(nextHeadX<0 || nextHeadX>grid.length-1 || nextHeadY<0 || nextHeadY>grid.length-1){
            count++;
            stop = true;
        }

        // 머리가 사과와 닿은 경우
        else if(grid[nextHeadX][nextHeadY]==-1){
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
        }

        // 그냥 이동하는 경우
        else{
            count++;

            // 꼬리 먼저 이동시킴
            grid[tailX][tailY] = 0;

            // 머리가 몸과 닿은 경우
            if(grid[nextHeadX][nextHeadY]>=1){
                stop = true;
            }
            else{
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
                grid[tailX][tailY] = 0;
                tailX = nextTailX;
                tailY = nextTailY;
            }
        }
        
        
        

        return stop;
    }

    public static void main(String[] args){
        /* 입력값 받기 */
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] grid = new int[n][n]; // 뱀 머리 : 5, 뱀 몸 : 1(U) 2(D) 3(R) 4(L) (방향), 사과 : -1
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        // 사과 위치 관련
        int appleX = 0;
        int appleY = 0; 
        for(int i = 0; i<m; i++){
            appleX = sc.nextInt()-1; // x좌표
            appleY = sc.nextInt()-1; // y좌표
            grid[appleX][appleY] = -1;
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
                for(int j = 0; j<dx[i]; j++){
                    stop = move(grid, dir[i]);
                    if(stop){
                        break;
                    }
                }
            }
            /*
            System.out.println("dir : "+dir[i]+", dx : "+dx[i]);
            for(int r = 0; r<grid.length; r++){
                for(int c = 0; c<grid[0].length; c++){
                    System.out.print(grid[r][c]+" ");
                }
                System.out.println();
            }
            System.out.println();
            */
        }
        System.out.print(count);
    }
}