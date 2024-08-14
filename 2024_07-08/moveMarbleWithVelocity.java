import java.util.*;

/* 구슬의 정보를 담은 객체 */
class Marble{
    /* 구슬 속성 */
    int x;      // 구슬의 행 위치
    int y;      // 구슬의 열 위치
    int dir;    // 구슬의 방향
    int vel;    // 구슬의 속도
    int num;      // 구슬의 번호

    /* 생성자 */
    public Marble(int x, int y, int dir, int vel, int num){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.vel = vel;
        this.num = num;
    }
}

public class moveMarbleWithVelocity {
    /* 방향을 나타내는 배열 : Up, Down, Right, Left */
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    /* 1초간 모든 구슬을 이동시키는 메서드 */
    public static void moveAll(int n, ArrayList<Marble> marbleList){
        for(int i = 0; i< marbleList.size(); i++){
            move(n, marbleList.get(i));     // 각 구슬 이동
        }
    }

    /* 구슬 하나 이동 메서드 */
    public static void move(int n, Marble marble){
        int x = marble.x;       // 구슬의 행 위치
        int y = marble.y;       // 구슬의 열 위치
        int dir = marble.dir;   // 구슬의 방향
        int vel = marble.vel;   // 구슬의 속도
        int num = marble.num;       // 구슬의 번호

        int nextX = x; // 구슬의 다음 행 위치
        int nextY = y; // 구슬의 다음 열 위치

        // 한 칸씩 이동시키며 벽인지 아닌지 판단
        for(int i = 0; i<vel; i++){
            nextX += dirX[dir];
            nextY += dirY[dir];
            if(nextX<0 || nextX>n-1 || nextY<0 || nextY>n-1){ // 벽을 만난 경우 : 시간 소요 없이 반대 방향으로 변경
                nextX -= dirX[dir];
                nextY -= dirY[dir];
                // 방향 전환
                switch(dir){
                    case 0 : // Up -> Down
                        dir = 1;
                        break;
                    case 1 : // Down -> Up
                        dir = 0;
                        break;
                    case 2 : // Right -> Left
                        dir = 3;
                        break;
                    case 3 : // Left -> Right
                        dir = 2;
                        break;
                    default :
                        throw new IllegalArgumentException("Invalid direction input");
                }
                nextX += dirX[dir];
                nextY += dirY[dir];
            }
        }

        // 변경 사항(위치, 방향) 반영
        marble.x = nextX;
        marble.y = nextY;
        marble.dir = dir;
    }

    /* k개를 초과하여 충돌이 일어났는지 체크하고, 우선도에 따라 지우는 메서드 */
    public static void removeMarble(int n, int k, ArrayList<Marble> marbleList){
        ArrayList<Marble>[][] grid = new ArrayList[n][n];

        // 각 격자에 ArrayList<Marble>을 선언하고, 해당 좌표에 구슬이 존재하는 경우, marbleList ArrayList에서 Marble 객체를 빼서 넣어줌
        while(marbleList.size()>0){
            Marble marble = marbleList.remove(0);
            if(grid[marble.x][marble.y]==null){ // 들어간 구슬이 없던 경우 ArrayList 생성
                grid[marble.x][marble.y] = new ArrayList<Marble>();
                grid[marble.x][marble.y].add(marble);
            }
            else{ // 들어간 구슬이 있던 경우 우선도 낮은 순으로 정렬 - 우선도 : 속도가 높을수록, 혹은 속도가 같다면 번호가 클수록 높음
                for(int i = 0; i< grid[marble.x][marble.y].size(); i++){
                    if(grid[marble.x][marble.y].get(i).vel > marble.vel){
                        grid[marble.x][marble.y].add(i, marble);
                        break;
                    }
                    else if(grid[marble.x][marble.y].get(i).vel==marble.vel){
                        if(grid[marble.x][marble.y].get(i).num > marble.num){
                            grid[marble.x][marble.y].add(i, marble);
                            break;
                        }
                    }
                    if(i == grid[marble.x][marble.y].size()-1){
                        grid[marble.x][marble.y].add(marble);
                        break;
                    }
                }
            }
        }

        // 충돌 체크
        for(int x = 0; x<n; x++){
            for(int y = 0; y<n; y++){
                if(grid[x][y]!=null && grid[x][y].size()>k){
                    while(grid[x][y].size()>k){
                        grid[x][y].remove(0); // 우선도가 낮은 구슬부터 제거됨
                    }
                }
                if(grid[x][y] != null){
                    marbleList.addAll(grid[x][y]); // 우선도가 낮은 구슬부터 들어감
                }
            }
        }
    }

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 격자 크기
        int m = sc.nextInt(); // 구슬 개수
        int t = sc.nextInt(); // 시간
        int k = sc.nextInt(); // 각 칸별 최대 구슬 수
        
        ArrayList<Marble> marbleList = new ArrayList<>(); // 구슬 정보 저장 배열 : 배열의 요소를 Marble 객체로 설정, 초깃값은 null
        
        int x, y, dir, vel, num; // 구슬 정보를 임시로 받을 변수

        for(int i = 0; i<m; i++){
            x = sc.nextInt() - 1; // 구슬 행 위치
            y = sc.nextInt() - 1; // 구슬 열 위치

            // 구슬 방향
            switch(sc.next()){
                case "U": // Up
                    dir = 0; 
                    break;
                case "D": // Down
                    dir = 1;
                    break;
                case "R": // Right
                    dir = 2;
                    break;
                case "L": // Left
                    dir = 3;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction input");
            }
            vel = sc.nextInt(); // 구슬 속도
            num = i+1; // 구슬의 번호

            marbleList.add(new Marble(x, y, dir, vel, num)); // Marble 객체를 선언하여 ArrayList로 삽입
        }

        // 실행
        for(int i = 0; i<t; i++){
            moveAll(n, marbleList);
            removeMarble(n, k, marbleList);
        }

        // 결과
        System.out.print(marbleList.size());
    }
}