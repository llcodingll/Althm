import java.util.Arrays;
import java.util.Scanner;

public class AppleTree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("땅 크기를 입력하세요 : ");
		int N = sc.nextInt();

		int[][] apple = new int[N][N];
		System.out.println(Arrays.deepToString(apple));

//		//int 배열을 String 배열로 변환...을 안 해도 같은 값 나오네
//		String[][] Apple = new String[apple.length][apple.length];
//		
//		for(int i = 0; i < apple.length; i++) {
//			Apple[i][i] = String.valueOf(apple[i][i]);
//		}
//		System.out.println(Arrays.toString(Apple));

		System.out.println("영양분을 입력하세요: ");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				apple[i][j] = sc.nextInt();
			}
		}

		// //배열 값 잘 들어갔는지 확인
		// System.out.println("입력된 배열 값:");
		// for(int i = 0; i < N; i++) {
		// 	for(int j = 0; j < N; j++) {
		// 		System.out.print(apple[i][j]+" ");
		// 	}
		// 	System.out.println();
		// }

		// 델타탐색을 이용
        int maxSum = 0;

        // 각 칸에서 상하좌우를 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = apple[i][j]; // 자기 자신의 값을 먼저 더해줍니다.

                // 상
                if (i - 1 >= 0) {
                    sum += apple[i - 1][j];
                }
                // 하
                if (i + 1 < N) {
                    sum += apple[i + 1][j];
                }
                // 좌
                if (j - 1 >= 0) {
                    sum += apple[i][j - 1];
                }
                // 우
                if (j + 1 < N) {
                    sum += apple[i][j + 1];
                }

                // 최대값 갱신
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println("가장 높은 영양분의 땅: " + maxSum);
    }
}