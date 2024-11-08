import java.io.*;
import java.util.*;
import java.lang.*;

/* 가로 줄 객체 */
class Line implements Comparable<Line>{
    int x1, x2; // x좌표 - 왼쪽 점, 오른쪽 점
    int y;      // y좌표

    /* 생성자 */
    public Line(int x, int y) {
        this.x1 = x;
        this.x2 = x+1;
        this.y = y;
    }

    /* 가로줄이 겹치는지 확인하는 메서드 */
    public static boolean isOverlap(Line L1, Line L2){
        if(L1.y == L2.y && (L1.x1 == L2.x2 || L1.x2 == L2.x1)){
            return true;            
        }
        else{
            return false;
        }
    }

    /* 선분의 왼쪽 끝점을 기준으로 정렬하기 위해 오버라이딩 */
    @Override
    public int compareTo(Line line){
        if(line.y < y){
            return 1;
        }
        else if(line.y == y){
            return 0;
        }
        else{
            return -1;
        }
    }
}
public class ghostLeg {
    /* 전역 변수 선언 */
    public static int minLine = 15; // 최소 가로줄 개수 최댓값 저장

    public static ArrayList<Line> originLineList = new ArrayList<>(); // 기존 가로줄 저장
    public static ArrayList<Integer> originGhostLegResult = new ArrayList<>(); // 기존 사다리 타기 시뮬레이션 결과 저장

    public static ArrayList<Line> lineMatchList = new ArrayList<>(); // 가로줄 조합 저장
    public static ArrayList<Integer> ghostLegResult = new ArrayList<>(); // 사다리 타기 시뮬레이션 결과 저장

    /* 가로줄 조합 메서드 */
    public static void matchLine(int n, int m, int x, int y){
        if(lineMatchList.size() >= minLine){
            return;
        }
        if(y == m+1){
            if(originGhostLegResult.equals(ghostLegResult)){
                minLine = Math.min(minLine, lineMatchList.size());
            }
            return;
        }
        if(x<n-1){
            // 해당 가로줄 미선택
            matchLine(n, m, x+1, y);

            // 해당 가로줄 선택
            Line newLine = new Line(x, y);
            if(canAddLine(newLine)){
                lineMatchList.add(newLine); // 가로줄 추가
                ghostLeg(newLine);
                matchLine(n, m, x+1, y); // 다음 가로줄 선택을 위해 재귀함수 호출
                ghostLeg(lineMatchList.get(lineMatchList.size()-1));
                lineMatchList.remove(lineMatchList.size()-1);
            }
        }
        else { // x == n-1
            // 해당 가로줄 미선택
            matchLine(n, m, 1, y+1);
            
            // 해당 가로줄 선택
            Line newLine = new Line(x, y);
            if(canAddLine(newLine)){
                lineMatchList.add(newLine); // 가로줄 추가
                ghostLeg(newLine);
                matchLine(n, m, 1, y+1);
                ghostLeg(lineMatchList.get(lineMatchList.size()-1));
                lineMatchList.remove(lineMatchList.size()-1);
            }
        }
    }

    /* 기존 사다리타기 시뮬레이션을 돌리는 메서드 */
    public static void originGhostLeg(Line line){
        // 가로줄의 양쪽 좌표에 해당하는 인덱스에 있는 값을 교환
        int tmp = originGhostLegResult.get(line.x1-1);
        originGhostLegResult.set(line.x1-1, originGhostLegResult.get(line.x2-1));
        originGhostLegResult.set(line.x2-1, tmp);
    }

    /* 사다리타기 시뮬레이션을 돌리는 메서드 */
    public static void ghostLeg(Line line){
        // 가로줄의 양쪽 좌표에 해당하는 인덱스에 있는 값을 교환
        int tmp = ghostLegResult.get(line.x1-1);
        ghostLegResult.set(line.x1-1, ghostLegResult.get(line.x2-1));
        ghostLegResult.set(line.x2-1, tmp);
    }

    /* 조합할 때 겹치는 가로줄이 존재하는지 확인하는 메서드 */
    public static boolean canAddLine(Line newLine) {
        for (Line line : lineMatchList) {
            if (Line.isOverlap(line, newLine)) {
                return false; // 겹치면 추가하지 않음
            }
        }
        return true;
    }

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        minLine = m; // 최솟값 세팅

        int x, y; // 임시로 좌표를 담을 변수
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            originLineList.add(new Line(x, y));
        }

        // 가로줄을 y를 기준으로 내림차순 정렬
        Collections.sort(originLineList);

        // 기존 주어진 가로줄에 따라 시뮬레이션 돌리기
        for(int i = 0; i<n; i++){ // 초기화
            originGhostLegResult.add(i+1);
            ghostLegResult.add(i+1);
        }
        for(int i = 0; i<m; i++){
            originGhostLeg(originLineList.get(i));
        }

        // 가로줄 조합 만들고 최댓값 구하기
        matchLine(n, m, 1, 1);

        // 결과 출력
        System.out.print(minLine);
    }
}