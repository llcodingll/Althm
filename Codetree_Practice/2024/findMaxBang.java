import java.io.*;
import java.util.*;
import java.awt.*;
import java.lang.*;

public class findMaxBang {
    /* 폭탄 종류 조합 */
    public static ArrayList<Integer> curBombCase = new ArrayList<>();

    /* 폭탄 유형별 범위 */
    public static int[][] one = {{-2,0}, {-1,0}, {0,0}, {1,0}, {2,0}};
    public static int[][] two = {{-1,0}, {0,-1}, {0,0}, {0,1}, {1,0}};
    public static int[][] three = {{-1,-1}, {-1,1}, {0,0}, {1,-1}, {1,1}};

    /* 폭탄 위치 */
    public static ArrayList<Point> bombPos = new ArrayList<>();

    /* 폭탄이 폭발한 범위 위치 */
    // arraylist를 사용하는 이유 : 1. 폭발 범위 추가 순서 파악 / 2. 직전 단계로 돌아가기 위한 remove에서, 중복된 폭발 범위로 인한 오류 발생 방지
    public static ArrayList<Point> explodePos = new ArrayList<>(); // 폭발 범위

    /* 최대 폭발 범위 */
    public static int maxCount = 0;

    /* 폭탄 조합 경우의 수를 구하는 메서드 */
    public static void bombCase(int currNum, int n){
        if(currNum==bombPos.size()+1){
            allExplode(n);
            return;
        }
        for(int i = 1; i<=3; i++){
            curBombCase.add(i);
            bombCase(currNum+1, n);
            curBombCase.remove(curBombCase.size()-1);
        }
    }

    /* 폭탄 조합을 받아 순회하며 전부 터뜨리는 메서드 */
    public static void allExplode(int n){
        // 순회하며 모든 폭탄을 터트림
        for(int i = 0; i<curBombCase.size(); i++){
            explode(n, curBombCase.get(i), i);
        }
        
        // 폭발 범위의 정확한 측정을 위한 중복된 위치 & 격자를 넘어간 위치 제거
        HashSet<Point> tmp = new HashSet<>(explodePos);
        Iterator<Point> iterator = tmp.iterator();
        while(iterator.hasNext()){
            Point p = iterator.next();
            if(p.x<0 || p.x>n-1 || p.y<0 || p.y>n-1){
                iterator.remove();
            }
        }

        // 기존 최댓값과, 지금 경우의 폭탄 폭발 범위를 비교하여, 더 큰 쪽을 최댓값에 저장 
        maxCount = Math.max(maxCount, tmp.size());

        // 폭발 범위 삭제
        explodePos.clear();
    }

    /* 폭탄 종류에 따라 폭발시키는 메서드 */
    public static void explode(int n, int type, int currIdx){
        // 폭탄 종류에 따라 폭발 범위 적용
        switch(type){
            case 1:
                for(int i = 0; i<5; i++){
                    explodePos.add(new Point(bombPos.get(currIdx).x+one[i][0], bombPos.get(currIdx).y+one[i][1]));
                }
                break;
            case 2:
                for(int i = 0; i<5; i++){
                    explodePos.add(new Point(bombPos.get(currIdx).x+two[i][0], bombPos.get(currIdx).y+two[i][1]));
                }
                break;
            case 3:
                for(int i = 0; i<5; i++){
                    explodePos.add(new Point(bombPos.get(currIdx).x+three[i][0], bombPos.get(currIdx).y+three[i][1]));
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int tmp = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                tmp = Integer.parseInt(st.nextToken());
                if(tmp==1){
                    bombPos.add(new Point(i, j));
                }
            }
        }

        bombCase(1, n);

        System.out.print(maxCount);
    }
}
