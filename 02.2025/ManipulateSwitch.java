import java.util.Scanner;

public class ManipulateSwitch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int[] beforeManipulateStatus = new int[N];
            for (int i = 0; i < N; i++) {
                beforeManipulateStatus[i] = sc.nextInt();
            }
            int[] afterManipulateStatus = new int[N];
            for (int i = 0; i < N; i++) {
                afterManipulateStatus[i] = sc.nextInt();
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                while (beforeManipulateStatus[i] != afterManipulateStatus[i]){
                    for (int j = i; j < N; j++) {
                        if(beforeManipulateStatus[j] == 0){
                            beforeManipulateStatus[j] = 1;
                        } else {
                            beforeManipulateStatus[j] = 0;
                        }
                    }
                    cnt++;
                }
            }

            System.out.println("#"+t+" "+cnt);
        }
    }
}
