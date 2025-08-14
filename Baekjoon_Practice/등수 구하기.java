import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int answer = 1;

        if(n > 0){
            int[] list = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            // 새로운 점수보다 높은 점수의 개수를 세어 등수 계산
            for(int i = 0; i < n; i++){
                if(list[i] > newScore) answer++;
            }

            // 랭킹 리스트에 진입할 수 없는 경우
            // 1. 랭킹이 가득 차있고 (n == p)
            // 2. 새로운 점수가 마지막 점수보다 작거나 같을 때
            if(n == p && newScore <= list[n-1]) {
                answer = -1;
            }
        }

        // 랭킹이 가득 차있지 않거나, 새로운 점수가 진입 가능한 경우
        // 하지만 등수가 P를 초과하면 랭킹에 들어갈 수 없음
        if(answer > p) {
            answer = -1;
        }

        System.out.print(answer);
    }
}