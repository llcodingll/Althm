import java.io.*;
import java.util.*;
import java.lang.*;

/* 선분 객체 */
class Line implements Comparable<Line>{
    int left, right; // 왼쪽 끝 점, 오른쪽 끝 점

    /* 생성자 */
    public Line(int left, int right) {
        this.left = left;
        this.right = right;
    }

    /* 두 선분이 겹치는지 판단하는 메서드 */
    public static boolean isOverlap(Line L, Line R){
        if(R.left <= L.right){
            return true;
        }
        else{
            return false;
        }
    }

    /* 선분의 왼쪽 끝점을 기준으로 정렬하기 위해 오버라이딩 */
    @Override
    public int compareTo(Line line){
        if(line.left < left){
            return 1;
        }
        else if(line.left == left){
            return 0;
        }
        else{
            return -1;
        }
    }
}
public class notOverlabLine {
    /* 선분 저장 */
    public static ArrayList<Line> lineList = new ArrayList<>();

    /* 선분 조합 저장 */
    public static ArrayList<Integer> lineCaseList = new ArrayList<>();

    /* 최대 선분 조합 개수 저장 */
    public static int maxNum = 0;

    /* 선분 조합에 대해, 겹치는 선분이 존재하는지 확인하는 메서드 */
    public static boolean isTotalOverlap(){
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i<lineCaseList.size()-1; i++){
            idx1 = lineCaseList.get(i);
            idx2 = lineCaseList.get(i+1);
            if(Line.isOverlap(lineList.get(idx1), lineList.get(idx2))){
                return true; // 선분 겹침
            }
        }
        return false; // 선분 안 겹침
    }

    /* 겹치지 않는 선분 조합 메서드 */
    public static void caseLine(int idx){
        if(idx == lineList.size()){
            if(!isTotalOverlap()){
                maxNum = Math.max(maxNum, lineCaseList.size());
            }
            return;
        }

        // idx번 선분 선택
        lineCaseList.add(idx); // 선분을 추가해줌
        caseLine(idx+1); // 다음 idx 선택을 위해 재귀함수 호출
        if(!lineCaseList.isEmpty()){
            lineCaseList.remove(lineCaseList.size()-1);
        }

        // idx번 선분 미선택
        caseLine(idx+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int left, right; // 임시로 왼쪽 점, 오른쪽 점을 담을 변수
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            lineList.add(new Line(left, right));
        }

        // 선분을 왼쪽 점을 기준으로 오름차순 정렬
        Collections.sort(lineList);

        // 선분 조합 만들고 최댓값 구하기
        caseLine(0);

        // 결과 출력
        System.out.print(maxNum);
    }
}