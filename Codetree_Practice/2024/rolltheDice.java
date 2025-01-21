import java.util.*;

public class rolltheDice {
    // 격자 위치 전역변수로 선언(함수 간 공유되도록)
    static int r = 0;
    static int c = 0;

    /* 주사위가 왼쪽으로 움직일때 격자에 숫자를 남기고 위치 이동 및 주사위 눈 위치 변경시키는 메소드 */
    public static void moveLeft(int[][] grid, int[] dice){
        if(c>0){
            c--; // 주사위 왼쪽 이동
            int[] nextDice = new int[6]; // 주사위 눈 위치 변경 임시 저장 변수
            // 왼쪽 이동으로 인한 주사위 변경
            nextDice[0] = dice[2]; // 왼쪽 > 바닥
            nextDice[1] = dice[3]; // 오른쪽 > 천장
            nextDice[2] = dice[1]; // 천장 > 왼쪽
            nextDice[3] = dice[0]; // 바닥 > 오른쪽
            nextDice[4] = dice[4]; // 위쪽 > 위쪽
            nextDice[5] = dice[5]; // 아래쪽 > 아래쪽

            for(int i = 0; i<6; i++){
                dice[i] = nextDice[i];//기존 주사위에 변경 위치 반영
            }

            grid[r][c] = dice[0]; // 주사위 바닥 숫자 격자에 남기기
        }
    }

    /* 주사위가 오른쪽으로 움직일때 격자에 숫자를 남기고 위치 이동 및 주사위 눈 위치 변경시키는 메소드 */
    public static void moveRight(int[][] grid, int[] dice){
        if(c<grid.length-1){
            c++; // 주사위 오른쪽 이동
            int[] nextDice = new int[6]; // 주사위 눈 위치 변경 임시 저장 변수
            // 오른쪽 이동으로 인한 주사위 변경
            nextDice[0] = dice[3]; // 오른쪽 > 바닥
            nextDice[1] = dice[2]; // 왼쪽 > 천장
            nextDice[2] = dice[0]; // 바닥 > 왼쪽
            nextDice[3] = dice[1]; // 천장 > 오른쪽
            nextDice[4] = dice[4]; // 위쪽 > 위쪽
            nextDice[5] = dice[5]; // 아래쪽 > 아래쪽

            for(int i = 0; i<6; i++){
                dice[i] = nextDice[i];//기존 주사위에 변경 위치 반영
            }

            grid[r][c] = dice[0]; // 주사위 바닥 숫자 격자에 남기기
        }
    }

    /* 주사위가 위쪽으로 움직일때 격자에 숫자를 남기고 위치 이동 및 주사위 눈 위치 변경시키는 메소드 */
    public static void moveUp(int[][] grid, int[] dice){
        if(r>0){
            r--; // 주사위 위쪽 이동
            int[] nextDice = new int[6]; // 주사위 눈 위치 변경 임시 저장 변수
            // 위쪽 이동으로 인한 주사위 변경
            nextDice[0] = dice[4]; // 위쪽 > 바닥
            nextDice[1] = dice[5]; // 아래쪽 > 천장
            nextDice[2] = dice[2]; // 왼쪽 > 왼쪽
            nextDice[3] = dice[3]; // 오른쪽 > 오른쪽
            nextDice[4] = dice[1]; // 천장 > 위쪽
            nextDice[5] = dice[0]; // 바닥 > 아래쪽

            for(int i = 0; i<6; i++){
                dice[i] = nextDice[i];//기존 주사위에 변경 위치 반영
            }

            grid[r][c] = dice[0]; // 주사위 바닥 숫자 격자에 남기기
        }
    }

    /* 주사위가 아래쪽으로 움직일때 격자에 숫자를 남기고 위치 이동 및 주사위 눈 위치 변경시키는 메소드 */
    public static void moveDown(int[][] grid, int[] dice){
        if(r<grid.length-1){
            r++; // 주사위 아래쪽 이동
            int[] nextDice = new int[6]; // 주사위 눈 위치 변경 임시 저장 변수
            // 아래쪽 이동으로 인한 주사위 변경
            nextDice[0] = dice[5]; // 아래쪽 > 바닥
            nextDice[1] = dice[4]; // 위쪽 > 천장
            nextDice[2] = dice[2]; // 왼쪽 > 왼쪽
            nextDice[3] = dice[3]; // 오른쪽 > 오른쪽
            nextDice[4] = dice[0]; // 바닥 > 위쪽
            nextDice[5] = dice[1]; // 천장 > 아래쪽

            for(int i = 0; i<6; i++){
                dice[i] = nextDice[i];//기존 주사위에 변경 위치 반영
            }

            grid[r][c] = dice[0]; // 주사위 바닥 숫자 격자에 남기기
        }
    }

    public static void main(String[] args) {
        // 입력 값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();           // 격자 크기
        int [][] grid = new int[n][n];  // 격자
        int m = sc.nextInt();           // 주사위 굴릴 횟수
        r = sc.nextInt()-1;             // 초기 주사위 위치(행)
        c = sc.nextInt()-1;             // 초기 주사위 위치(열)
        String[] dir = new String[m];   // 주사위가 굴러갈 방향
        for(int i = 0; i<m; i++){
            dir[i] = sc.next();
        }
        
        //주사위의 눈을 저장하는 변수 
        //방향 순서는 [0] 바닥, [1] 천장, [2] 왼쪽, [3] 오른쪽, [4] 위쪽, [5] 아래쪽 
        int[] dice = {6, 1, 4, 3, 5, 2};

        grid[r][c] = dice[0];

        for(String d : dir){
            switch(d){
                case "L":
                    moveLeft(grid, dice);
                    break;
                case "R":
                    moveRight(grid, dice);
                    break;
                case "U":
                    moveUp(grid, dice);
                    break;
                case "D":
                    moveDown(grid, dice);
                    break;
            }
        }

        // 격자에 남겨진 숫자 계산 
        int sum = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                sum+=grid[i][j];
            }
        }

        System.out.print(sum);
    }
}