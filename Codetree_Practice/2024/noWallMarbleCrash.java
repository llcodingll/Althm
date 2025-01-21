import java.util.*;
import java.io.*;

/* 격자 좌표 표현 */
class Point {
    /* 동일한 x, y 좌표로 객체를 생성한 경우 같은 객체로 인식되도록 부모 클래스의 메서드를 오버라이딩 */
    @Override
    public boolean equals(Object o) {
        if (this == o){ // 두 객체가 동일한 참조(즉, 동일한 메모리 주소)를 가리킬 경우
            return true;
        }
        if (o == null || getClass() != o.getClass()){ // 다른 클래스의 인스턴스이거나, 비교 대상이 null일 경우
            return false;
        } 
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
    @Override
    public int hashCode() {
        // 주어진 x 필드, y 필드 기반으로 기반으로 해시 코드를 생성함, x 값, y 값이 동일한 경우 동일한 해시값 생성
        return Objects.hash(x, y);
    }

    /* 이동 방향을 나타내는 상수 배열 : Up, Down, Right, Left */
    static int[] dirX = {0, 0, 1, -1};
    static int[] dirY = {1, -1, 0, 0};

    /* 좌표 속성 */
    double x;
    double y;

    /* 좌표를 설정하는 메서드 */
    public void setPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    /* 좌표값 일치하는지 확인하는 메서드 */
    public static boolean isSame(Point a, Point b){
        if(a.x==b.x && a.y==b.y){
            return true;
        }
        else{
            return false;
        }
    }

    /* 1초 동안 방향에 따라 좌표 이동 시키는 메서드 */
    public static void move(double dis, int dir, Point point){
        // dir : 0(Up), 1(Down), 2(Right), 3(Left) / dis : 1초 동안 이동할 거리
        point.x += dirX[dir] * dis;
        point.y += dirY[dir] * dis;
    }
}

/* 구슬의 정보를 담은 객체 */
class Marble{
    /* 구슬이 1초에 움직이는 거리 상수 */
    static double dis = 0.5;

    /* 구슬 속성 */
    public Point point; // 구슬 좌표
    int dir;            // 구슬의 방향(direction)
    int w;              // 구슬의 무게(weight)
    int num;            // 구슬의 번호(number)

    /* 생성자 */
    public Marble(double x, double y, int dir, int w, int num){
        this.point = new Point();
        this.point.setPoint(x, y);
        this.dir = dir;
        this.w = w;
        this.num = num;
    }

    /* 이동 이전, 구슬의 초기 최소 x 좌표값, 최소 y 좌표값 구하는 메서드 */
    public static Point findMinPoint(ArrayList<Marble> marbleList){
        // 최소 x, y 좌표
        double minX = 1001;
        double minY = 1001;

        // 완전 탐색을 통해 최소 x 좌표값, 최소 y 좌표값을 찾음
        for(int i = 0; i< marbleList.size(); i++){
            Point marblePoint = marbleList.get(i).point;
            if(marblePoint.x<minX){
                minX = marblePoint.x;
            }
            if(marblePoint.y<minY){
                minY = marblePoint.y;
            }
        }

        Point minPoint = new Point();
        minPoint.setPoint(minX, minY);
        return minPoint;
    }

    /* 이동 이전, 구슬의 초기 최대 x 좌표값, 최대 y 좌표값 구하는 메서드 */
    public static Point findMaxPoint(ArrayList<Marble> marbleList){
        // 최대 x, y 좌표
        double maxX = -1001;
        double maxY = -1001;

        // 완전 탐색을 통해 최대 x 좌표값, 최대 y 좌표값을 찾음
        for(int i = 0; i< marbleList.size(); i++){
            Point marblePoint = marbleList.get(i).point;
            if(marblePoint.x>maxX){
                maxX = marblePoint.x;
            }
            if(marblePoint.y>maxY){
                maxY = marblePoint.y;
            }
        }

        Point maxPoint = new Point();
        maxPoint.setPoint(maxX, maxY);
        return maxPoint;
    }

    /* 충돌 가능성 파악 메서드 : 최소 x 좌표값, 최소 y 좌표값, 최대 x 좌표값, 최대 y 좌표값으로 형성된 상자를 구슬이 전부 벗어났는지 확인 */
    public static boolean isAllOut(Point minPoint, Point maxPoint, ArrayList<Marble> marbleList){
        for(int i = 0; i< marbleList.size(); i++){
            Point marblePoint = marbleList.get(i).point;
            if(marblePoint.x < minPoint.x || marblePoint.x > maxPoint.x || marblePoint.y < minPoint.y || marblePoint.y > maxPoint.y){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    /* 1초간 모든 구슬을 이동시키는 메서드 */
    public static void moveAllMarble(ArrayList<Marble> marbleList){
        for(int i = 0; i< marbleList.size(); i++){
            Marble marble = marbleList.get(i);
            Point.move(dis, marble.dir, marble.point); // 각 구슬 이동
        }
    }

    /* 충돌 여부 체크, 충돌이 있는 경우 더 영향력이 큰 구슬만 남기는 메서드 */
    public static boolean crashCheck(ArrayList<Marble> marbleList){
        boolean isCrash = false; // 충돌 여부 저장 변수
        Map<Point, Marble> grid = new HashMap<>(); // 좌표(키)와 구슬(값)을 저장

        // 구슬을 완전 탐색 하며 충돌 여부를 체크함
        while(marbleList.size()>0){
            Marble marble = marbleList.remove(0);
            
            // 구슬이 동일한 좌표 위치에 겹쳐지는 경우(충돌 발생) 영향력이 큰 구슬 객체로 덮어 씌우기
            if(grid.containsKey(marble.point)){ // 해당 좌표에 이미 구슬이 존재하는 경우
                isCrash = true;
                Marble inMarble = grid.get(marble.point); // 격자 내에 존재 했던 구슬
                //System.out.println("격자 내에 존재했던 구슬 num:"+inMarble.num+", x:"+inMarble.point.x+", y:"+inMarble.point.y);

                if(marble.w > inMarble.w){ // 넣으려는 구슬의 무게가 격자 내에 존재했던 구슬의 무게보다 더 무거운 경우
                    grid.put(marble.point, marble);
                    //System.out.println("격자 안에 남은 구슬 num:"+marble.num+", x:"+marble.point.x+", y:"+marble.point.y);
                }
                else if(marble.w == inMarble.w){ // 넣으려는 구슬의 무게가 격자 내에 존재했던 구슬의 무게와 같은 경우
                    if(marble.num > inMarble.num){ // 넣으려는 구슬의 번호가 격자 내에 존재했던 구슬의 번호보다 더 큰 경우
                        grid.put(marble.point, marble);
                        //System.out.println("격자 안에 남은 구슬 num:"+marble.num+", x:"+marble.point.x+", y:"+marble.point.y);
                    }
                }
            }
            else{ // 해당 좌표에 구슬이 존재하지 않는 경우
                grid.put(marble.point, marble);
                //System.out.println("새로 들어가게 된 구슬 num:"+marble.num+", x:"+marble.point.x+", y:"+marble.point.y);
            }
        }

        // 충돌이 끝나고 남은 구슬을 다시 marbleList에 넣음
        for(Point key : grid.keySet()){
            marbleList.add(grid.get(key));
        }

        return isCrash;
    }
}

public class noWallMarbleCrash {
    public static int testcase(ArrayList<Marble> marbleList){
        int totalTime = 0; // 전체 시간
        int lastCrashTime = -1; // 마지막 충돌이 일어난 시간

        // 충돌 가능성 여부를 파악하기 위하여 초기 구슬이 놓인 좌표 중 최소값, 최대값을 객체에 저장
        Point minPoint = Marble.findMinPoint(marbleList); // 최소 x 좌표, 최소 y 좌표
        Point maxPoint = Marble.findMaxPoint(marbleList); // 최대 x 좌표, 최대 y 좌표
        
        //충돌의 가능성이 없을 때 까지 반복
        while(!Marble.isAllOut(minPoint, maxPoint, marbleList)){
            Marble.moveAllMarble(marbleList);
            totalTime ++;
            if(Marble.crashCheck(marbleList)){
                lastCrashTime = totalTime;
            }
        }

        return lastCrashTime;
    }

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); // 테스트케이스
        int[] timeResult = new int[t]; // 테스트케이스 결과, 가장 마지막으로 충돌이 일어난 시간 저장
        
        // 테스트케이스 실행
        for(int i = 0; i<t; i++){
            // 입력 받기 : 구슬 정보 저장
            st = new StringTokenizer(br.readLine());

            ArrayList<Marble> marbleList = new ArrayList<>(); // 구슬 객체를 저장하는 ArrayList
            int n = Integer.parseInt(st.nextToken()); // 구슬 개수
            double x, y;                              // 구슬 좌표
            int dir, w, num;                          // 구슬 이동 방향, 구슬 무게, 구슬 번호

            for(int j = 0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                x = Double.parseDouble(st.nextToken()); // 구슬 x 좌표
                y = Double.parseDouble(st.nextToken()); // 구슬 y 좌표
                w = Integer.parseInt(st.nextToken()); // 구슬 무게

                // 구슬 방향
                switch(st.nextToken()){
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
                num = j+1; // 구슬의 번호
                marbleList.add(new Marble(x, y, dir, w, num)); // Marble 객체를 선언하여 ArrayList로 삽입
            }

            timeResult[i] = testcase(marbleList);
        }

        // 결과 출력
        for(int time : timeResult){
            System.out.println(time);
        }
    }
}