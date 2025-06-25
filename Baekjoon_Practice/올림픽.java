import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] medals = new int[n][4];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++){
                medals[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // K번 국가의 메달 정보 찾기
        int[] targetMedals = null;
        for (int i = 0; i < n; i++) {
            if (medals[i][0] == k) {
                targetMedals = medals[i];
                break;
            }
        }

        // K번 국가보다 더 잘한 국가의 수 계산
        int betterCount = 0;
        for (int i = 0; i < n; i++) {
            if (medals[i][0] != k && isBetter(medals[i], targetMedals)) {
                betterCount++;
            }
        }

        // 등수 = 자신보다 더 잘한 나라 수 + 1
        System.out.println(betterCount + 1);
    }

    public static boolean isBetter(int[] country1, int[] country2) {
        // 금메달 수 비교
        if (country1[1] > country2[1]) return true;
        if (country1[1] < country2[1]) return false;

        // 금메달이 같으면 은메달 수 비교
        if (country1[2] > country2[2]) return true;
        if (country1[2] < country2[2]) return false;

        // 금, 은메달이 같으면 동메달 수 비교
        if (country1[3] > country2[3]) return true;

        return false; // 모든 메달 수가 같거나 더 못한 경우
    }
}