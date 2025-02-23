
import java.util.Scanner;

public class 두개의숫자열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            int max = 0;

            if (N > M) {
                //swap해주면 됨
                int tmp = N;
                N = M;
                M = tmp;

                int[] tmpArr = A;
                A = B;
                B = tmpArr;
            }
            if (N < M) {
                // for문 2개를 돌면서 교차해서 비교하면 됨
                // 더 큰 쪽의 배열 범위르 벗어나면 안 되니까 작은 배열 쪽의 범위를 빼줌
                for (int i = 0; i <= M - N; i++) {
                    int sum = 0; //더한 값 저장해야지
                    //위의 조건에서 큰 쪽의 이동범위를 제한했으므로 작은 쪽의 N값은 자유롭게 사용 가능
                    for (int j = 0; j < N; j++) {
                        int num1 = A[j];
                        int num2 = B[i + j];
                        int multValue = num1 * num2;
                        sum += multValue;
                    }

                    //최대값인지 판단
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
