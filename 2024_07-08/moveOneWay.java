import java.util.*;

public class moveOneWay {
    /* 방향을 나타내는 배열 : Up, Down, Right, Left */
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    /* 테스트케이스를 수행하고 격자에 남아있는 구슬의 수를 반환하는 메서드 */
    public static int testCase(int[][] dir, int[][] nextDir, int[][] count, int[][] nextCount){
        int countResult = 0;
        // 2*n 초 만큼의 시간이 지나면 똑같은 방향, 똑같은 위치에 구슬이 위치하게 되므로 그만큼 반복
        for(int i = 0; i<2*dir.length; i++){
            moveAllMarble(dir, nextDir, count, nextCount);
        }

        // 남은 구슬의 수를 세고 반환
        countResult = countMarble(count);
        return countResult;
    }

    /* 격자를 완전 탐색하며 구슬을 찾아 모두 이동시키고 충돌이 일어난 구슬은 지우는 메서드 */
    public static void moveAllMarble(int[][] dir, int[][] nextDir, int[][] count, int[][] nextCount){
        // 격자 완전 탐색하며 구슬 찾기
        for(int i = 0; i<count.length; i++){
            for(int j = 0; j<count.length; j++){
                if(count[i][j]==1){
                    int d = dir[i][j];
                    move(d, nextDir, nextCount, i, j);
                }
            }
        }

        // dir에 nextDir 덮어 씌우기
        copyGrid(dir, nextDir);

        // count에 nextCount 덮어 씌우기
        copyGrid(count, nextCount);

        // 충돌이 일어난 구슬 지우기
        removeConflictMarble(count);

        // nextDir 초기화
        initGrid(nextDir);

        // nextCount 초기화
        initGrid(nextCount);
    }

    /* 방향대로 한칸 움직이는 메서드 - 벽을 만난 경우엔 반대 방향으로 바꿈 */
    public static void move(int d, int[][] nextDir, int[][] nextCount, int x, int y){

        // 벽을 만나지 않은 경우
        if(x+dirX[d]>=0 && x+dirX[d]<=nextDir.length-1 && y+dirY[d]>=0 && y+dirY[d]<=nextDir.length-1){
            nextDir[x+dirX[d]][y+dirY[d]] = d;
            nextCount[x+dirX[d]][y+dirY[d]] += 1;
        }
        // 벽을 만난 경우 - 반대 방향으로 변경
        else{
            switch(d){
                case 0 : // Up -> Down
                    nextDir[x][y] = 1;
                    nextCount[x][y] += 1;
                    break;
                case 1 : // Down -> Up
                    nextDir[x][y] = 0;
                    nextCount[x][y] += 1;
                    break;
                case 2 : // Right -> Left
                    nextDir[x][y] = 3;
                    nextCount[x][y] += 1;
                    break;
                case 3 : // Left -> Right
                    nextDir[x][y] = 2;
                    nextCount[x][y] += 1;
                    break;
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
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] result = new int[t];
        int n = 0; // 격자 크기
        int m = 0; // 구슬 수
        int x = 0; // 구슬 위치(행)
        int y = 0; // 구슬 위치(열)

        // 테스트 케이스 만큼 반복
        for(int i =0; i<t; i++){
            n = sc.nextInt();
            m = sc.nextInt();
            int[][] dir = new int[n][n];
            int[][] nextDir = new int[n][n];
            int[][] count = new int[n][n];
            int[][] nextCount = new int[n][n];
            for(int j = 0; j<m; j++){
                x = sc.nextInt()-1;
                y = sc.nextInt()-1;
                switch(sc.next()){
                    case "U":
                        dir[x][y] = 0;
                        count[x][y] = 1;
                        break;
                    case "D":
                        dir[x][y] = 1;
                        count[x][y] = 1;
                        break;
                    case "R":
                        dir[x][y] = 2;
                        count[x][y] = 1;
                        break;
                    case "L":
                        dir[x][y] = 3;
                        count[x][y] = 1;
                        break;
                }
            }
            result[i] = testCase(dir, nextDir, count, nextCount);
        }

        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}