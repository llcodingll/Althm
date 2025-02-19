
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 암호문3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt(); //암호문의 크기

            //암호문을 저장하기 위해 연결리스트를 활용하면 좋겠지요: 배열처럼 크기를 계산하기 힘드니까!
            List<Integer> list = new LinkedList<>();
            //기본 암호문 뭉치 완성
            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }

            //추가 명령어
            int M = sc.nextInt();

            for (int i = 0; i < M; i++) {
                char cmd = sc.next().charAt(0);
                //cmd : I/D/A
                if(cmd == 'I'){
                    int idx = sc.nextInt();
                    int count = sc.nextInt();
                    //count만큼의 암호문 추가로 들어온다
                    for(int j = 0; j < count; j++){
                        //입력한 값을 누적
                        list.add(idx+j, sc.nextInt());
                    }
                } else if (cmd == 'D'){
                    int idx = sc.nextInt(); //여기부터
                    int count = sc.nextInt(); //이만큼 삭제
                    for(int j = 0; j < count; j++){
                        list.remove(idx);
                    }
                } else { //'A'일 때
                    int count = sc.nextInt();
                    for(int j = 0; j < count; j++){
                        list.add(sc.nextInt()); //가장 마지막에 붙이겠다
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#"+t);
            for(int i = 0; i < 10; i++){
                sb.append(" "+list.get(i));
            }
            System.out.println(sb);
        }
    }
}
