import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        } // 입력

        // 시계 방향으로 90도 회전했다는 건, 0번째끼리 1행, 1번째끼리 2행, 2번째끼리 3행(j고정)
        int[][] result = new int[M][N];
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i >= 0; i--) {
                result[j][i] = arr[i][j];
                System.out.print(result[j][i] + " ");
            }
            System.out.println();
        }

        //시계 방향으로 180도 회전한 경우,
        int[][] result2 = new int[N][M];
        for (int i = N-1; i >= 0; i--) {
            for (int j = M-1; j >= 0; j--) {
                result2[i][j] = arr[i][j];
                System.out.print(result2[i][j]+" ");
            }
            System.out.println();
        }

        //시계 방향으로 270도 회전한 경우,
        int[][] result3 = new int[M][N];
        for (int j = M-1; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                result3[j][i] = arr[i][j];
                System.out.print(result3[j][i]+" ");
            }
            System.out.println();
        }
    }
}