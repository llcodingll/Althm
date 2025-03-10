
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_ArrayRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] result = new int[M][N];
        int K = 3;

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        // 입력
        for (int i = 1; i <= K; i++) {
            if (i % 2 != 0) {
                rotate(M, arr, result, N);
            } else {
                rotate(N, result, arr, M);
            }
        }
    }

    /**
     * @param l 새 배열의 행의 개수 (원본의 열 수)
     * @param odd 원본 배열
     * @param even 회전 결과가 저장될 배열
     * @param c 원본 배열의 행의 개수
     */
    private static void rotate(int l, int[][] odd, int[][] even, int c) {

        for (int i = 0; i < l; i++) {
            for (int j = c - 1; j >= 0; j--) {
                even[i][c - 1 - j] = odd[j][i];
                System.out.print(even[i][c - 1 - j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }
}
