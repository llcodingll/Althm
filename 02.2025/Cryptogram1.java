
import java.util.ArrayList;
import java.util.Scanner;

public class Cryptogram1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 원본 암호문의 배열의 길이 
            ArrayList<Integer> code = new ArrayList<>(N); //원본 암호문을 넣을 곳
            // 2번째 입력 값을 넣어줄 배열
            for (int i = 0; i < N; ++i) {
                code.add(sc.nextInt());
            }
            int command = sc.nextInt(); // 명령어의 개수
            for (int i = 0; i < command; ++i) {
                //I(삽입) x(원본 거 기준 X다음에 넣어라), y(몇개의 숫자를 넣을지), s(y개의 숫자)
                sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                ArrayList<Integer> s = new ArrayList<>(y); // y만큼의 크기를 가진 배열을 선언한다.

                for (int j = 0; j < y; ++j) {
                    s.add(sc.nextInt()); // 해당 배열의 값을 넣어준다.
                }

                //앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다.
                code.addAll(x, s);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + t);
            //앞에 10개만!
            for (int i = 0; i < 10; i++) {
                sb.append(" " + code.get(i));
            }
            System.out.println(sb);
        }
    }
}
