import java.util.Scanner;

public class FlyCatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] area = new int[N][N];
			int M = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					area[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int currI = i;
					int currJ = j;
					int sum = 0;
					for(int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							if(currI+k < N && currJ+l < N) {
								sum+=area[currI+k][currJ+l];
							}
						}
					}
					if(sum > max) {
						max = sum;
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
