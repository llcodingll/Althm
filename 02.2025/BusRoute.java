
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BusRoute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int start = 0;
            int end = 0;

            ArrayList<Integer> cnt = new ArrayList<>();

            for (int n = 0; n < N; n++) {
                start = sc.nextInt();
                end = sc.nextInt();

                for (int j = start; j <= end; j++) {
                    cnt.add(j);
                }
            }

            int P = sc.nextInt();

            ArrayList<Integer> C = new ArrayList<>();
            ArrayList<Integer> resultCnt = new ArrayList<>();

            for (int i = 0; i < P; i++) {
                C.add(sc.nextInt());

            }

            int frequency = 0;
            for (int j = 0; j < P; j++) {
                frequency = Collections.frequency(cnt, C.get(j));
                resultCnt.add(frequency);
            }

            System.out.print("#" + t);
            for (int i : resultCnt) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}
