import java.util.*;
import java.lang.*;

/* 구슬의 정보를 담은 객체 */
class Marble{
    /* 구슬 속성 */
    int x;      // 구슬의 행 위치
    int y;      // 구슬의 열 위치
    int dir;    // 구슬의 방향(direction)
    int w;      // 구슬의 무게(weight)
    int num;    // 구슬의 번호(number)

    /* 구슬의 방향을 나타내는 배열 : Up, Down, Right, Left */
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    /* 생성자 */
    public Marble(int x, int y, int dir, int w, int num){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.w = w;
        this.num = num;
    }

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
        int w = marble.w;       // 구슬의 무게
        int num = marble.num;   // 구슬의 번호

        // 이동 시킴 (벽인지 아닌지 판단)
        int nextX = x+dirX[dir]; // 구슬의 다음 행 위치
        int nextY = y+dirY[dir]; // 구슬의 다음 열 위치
        
        if(nextX<0 || nextX>n-1 || nextY<0 || nextY>n-1){ // 벽을 만난 경우 : 반대 방향으로 변경
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
        }

        // 변경 사항(위치, 방향) 반영
        marble.x = nextX;
        marble.y = nextY;
        marble.dir = dir;
    }

    /* 충돌 여부 체크 및 충돌 시 구슬을 합치는 메서드 */
    public static void mergeMarble(int n, ArrayList<Marble> marbleList){
        ArrayList<Marble>[][] grid = new ArrayList[n][n];

        // 각 격자에 ArrayList<Marble>을 선언하고, 해당 좌표에 구슬이 존재하는 경우, marbleList ArrayList에서 Marble 객체를 빼서 넣어줌
        while(marbleList.size()>0){
            Marble marble = marbleList.remove(0);
            if(grid[marble.x][marble.y]==null){ // 들어간 구슬이 없던 경우 ArrayList 생성
                grid[marble.x][marble.y] = new ArrayList<Marble>();
                grid[marble.x][marble.y].add(marble);
            }
            else{ // 들어간 구슬이 있던 경우 번호가 작은 순으로 정렬
                for(int i = 0; i< grid[marble.x][marble.y].size(); i++){
                    if(marble.num<grid[marble.x][marble.y].get(i).num){
                        grid[marble.x][marble.y].add(i, marble);
                        break;
                    }
                    if(i == grid[marble.x][marble.y].size()-1){
                        grid[marble.x][marble.y].add(marble);
                        break;
                    }
                }
            }
        }

        // 완전 탐색하며 구슬이 있는 칸에서 충돌 체크 및 충돌 발생 시 구슬 합치기
        for(int x = 0; x<n; x++){
            for(int y = 0; y<n; y++){
                if(grid[x][y]!=null){ // 해당 격자 칸에 구슬이 있는 경우
                    if(grid[x][y].size()>1){ // 구슬이 충돌한 상황
                        Marble tmp = new Marble(x, y, grid[x][y].get(grid[x][y].size()-1).dir, 0, grid[x][y].get(grid[x][y].size()-1).num);
                        tmp.w = 0;
                        while(grid[x][y].size()>0){ // 구슬 합침
                            tmp.w += grid[x][y].get(0).w;
                            grid[x][y].remove(0); // 우선도가 낮은 구슬부터 제거됨
                        }
                        marbleList.add(tmp);
                    }
                    else{
                        marbleList.add(grid[x][y].get(0));
                        grid[x][y].remove(0);
                    }
                }
            }
        }
    }
}

public class moveAndMerge {
    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 격자 크기
        int m = sc.nextInt(); // 구슬 개수
        int t = sc.nextInt(); // 시간
        
        ArrayList<Marble> marbleList = new ArrayList<>(); // 구슬 정보 저장 배열 : 배열의 요소를 Marble 객체로 설정, 초깃값은 null
        
        int x, y, dir, w, num; // 구슬 정보를 임시로 받을 변수

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
            w = sc.nextInt(); // 구슬 무게
            num = i+1; // 구슬의 번호

            marbleList.add(new Marble(x, y, dir, w, num)); // Marble 객체를 선언하여 ArrayList로 삽입
        }

        // 실행
        for(int i = 0; i<t; i++){
            Marble.moveAll(n, marbleList);
            Marble.mergeMarble(n, marbleList);
        }

        int maxWeight = 0;

        for(Marble mar : marbleList){
            maxWeight = Math.max(mar.w, maxWeight);
        }

        // 결과
        System.out.print(marbleList.size()+" "+maxWeight);
    }
}