import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int s = 0; // 32비트 정수로 1~20 표현
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "add":
                    int addNum = Integer.parseInt(st.nextToken());
                    s |= (1 << addNum);
                    break;
                case "remove":
                    int removeNum = Integer.parseInt(st.nextToken());
                    s &= ~(1 << removeNum);
                    break;
                case "check":
                    int checkNum = Integer.parseInt(st.nextToken());
                    sb.append((s & (1 << checkNum)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    int toggleNum = Integer.parseInt(st.nextToken());
                    s ^= (1 << toggleNum);
                    break;
                case "all":
                    s = (1 << 21) - 2; // 1~20 비트만 1로 설정
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }

        // StringBuilder에 저장된 결과를 출력
        System.out.print(sb.toString());
    }
}