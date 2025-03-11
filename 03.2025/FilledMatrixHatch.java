
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FilledMatrixHatch {

    static int[] di = {-1};
    static int[] dj = {1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] nums = new int[N][N];

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = cnt;
                for (int k = 0; k < N; k++) {
                    int ni = i + di[0] * k;
                    int nj = j + dj[0] * k;
                    if (ni < N && ni >= 0 && nj < N && nj >= 0) {
                        nums[ni][nj] = cnt++;
                    }
                }
                if (i != N - 1) {
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
