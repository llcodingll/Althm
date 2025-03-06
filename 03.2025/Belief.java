
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 신뢰 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); //버튼 개수

            //푸는 방법2 : 배열 / deQueue
            //순서 기록
            Deque<String> schedule = new LinkedList<>();
            Deque<Integer> blue = new LinkedList<>();
            Deque<Integer> orange = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String str = sc.next();
                if (str.equals("B")) {
                    int range = sc.nextInt();
                    blue.offer(range);
                }
                if (str.equals("O")) {
                    int range = sc.nextInt();
                    orange.offer(range);
                }

                schedule.offer(str);
            }

            //시작 위치 설정
            int blueLocation = 1;
            int orangeLocation = 1;

            //시간 설정
            int time = 0;

            //구현 방법1: 시간을 기준으로 매초마다 진행하도록 구현
            while (!schedule.isEmpty()) {
                //블루의 목적지
                int blueDes = blue.isEmpty() ? 0 : blue.poll();
                //오렌지의 목적지
                int orangeDes = orange.isEmpty() ? 0 : orange.poll();

                //목적지와의 거리 계산
                int blueRange = Math.abs(blueDes - blueLocation);
                int orangeRange = Math.abs(orangeDes - orangeLocation);

                //스케쥴이 모두 비어있으면 while문 탈출
                String str = schedule.poll();

                if (str.equals("B")) {
                    //현재 위치가 도착 위치인지 체크
                    if (blueLocation == blueDes) {
                        //도착이면 버튼 누르기
                        time++; //버튼 누를 때 1초 걸리니까 1초 증가

                        //버튼을 누르는 순간 오렌지가 이동할 수도 있음
                        if (orangeRange > 0) {
                            //이동할 거리가 남아있다는 소리
                            //이동할 방향을 찾아 이동해야 함
                            if (orangeDes > orangeLocation) {
                                orangeLocation++; //그러면 1칸 이동해야지
                            } else {
                                orangeLocation--;
                            }
                        }
                        //오렌지 하나 처리하고 다시 오렌지 값 처리
                        orange.addFirst(orangeDes);
                        continue;
                    }
                } else if (str.equals("O")) {
                    if (orangeLocation == orangeDes) {
                        time++;

                        if (blueRange > 0) {
                            if (blueDes > blueLocation) {
                                blueLocation++;
                            } else {
                                blueLocation--;
                            }
                        }
                        blue.addFirst(blueDes);
                        continue;
                    }

                }
                //버튼을 누르는 단계가 아닌 상황
                //이동
                time++;

                //이동 처리에 대해 메서드로 분리해도 되지만 여기서는 while문 안쪽에서 한번에 처리
                if (blueRange > 0) {
                    // 이동할 방향을 찾기
                    if (blueDes > blueLocation) {
                        // 오른쪽으로 이동할경우
                        blueLocation++;
                    } else {
                        blueLocation--;
                    }
                }

                // 블루가 이동후에 오렌지도 똑같이 이동할수있음 ( 둘은 다른 복도에 있음 )
                if (orangeRange > 0) { // 이동할 거리가 남아있을경우
                    // 이동할 방향을 찾기
                    if (orangeDes > orangeLocation) {
                        // 오른쪽으로 이동할경우
                        orangeLocation++;
                    } else {
                        orangeLocation--;
                    }
                }

                // 버튼을 누르는 상황이 아니므로 다음 while 진행을 위해 값을 다시 세팅해줌
                blue.addFirst(blueDes);
                orange.addFirst(orangeDes);
                schedule.addFirst(str);

            }

            System.out.println("#" + t + " " + time);

        }
    }
    static String input = "\r\n"
            + //
            "3\r\n"
            + //
            "4 B 2 O 1 O 2 B 4\r\n"
            + //
            "3 B 5 B 8 O 100\r\n"
            + //
            "2 O 2 O 1" + " ";
}
