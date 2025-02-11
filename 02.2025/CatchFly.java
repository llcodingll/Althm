import java.util.Scanner;


public class CatchFly {
	static int[] dr1 = { -1, 1, 0, 0 };
	static int[] dc1 = { 0, 0, -1, 1 };

	static int[] dr2 = { -1, -1, 1, 1 };
	static int[] dc2 = { -1, 1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);


		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
	
					int tmp = arr[r][c];
					int tmp2 = arr[r][c];
					for (int d = 0; d < 4; d++) {
						
						for (int m = 1; m < M; m++) {
							int nr2 = r + dr2[d] * m;
							int nc2 = c + dc2[d] * m;

							if (nr2 >= 0 && nr2 < N && nc2 >= 0 && nc2 < N) {
								tmp2 += arr[nr2][nc2];
							}

							int nr = r + dr1[d] * m;
							int nc = c + dc1[d] * m;

							if (nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;
							tmp += arr[nr][nc];
						}
					}	
					int max = Math.max(tmp, tmp2);
					ans = ans < max ? max : ans;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	static String input = "2\r\n" + "5 2\r\n" + "1 3 3 6 7\r\n" + "8 13 9 12 8\r\n" + "4 16 11 12 6\r\n"
			+ "2 4 1 23 2\r\n" + "9 13 4 7 3\r\n" + "6 3\r\n" + "29 21 26 9 5 8\r\n" + "21 19 8 0 21 19\r\n"
			+ "9 24 2 11 4 24\r\n" + "19 29 1 0 21 19\r\n" + "10 29 6 18 4 3\r\n" + "29 11 15 3 3 29\r\n" + " ";
}
