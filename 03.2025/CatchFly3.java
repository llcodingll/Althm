import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CatchFly3 {
    static int N, M;
    static int[] straightdi = {-1, 1, 0, 0};
    static int[] straightdj = {0, 0, -1, 1};
    static int[] crossdi = {-1, -1, 1, 1};
    static int[] crossdj = {-1, 1, -1, 1};
    static int max, crossmax;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer NMInputs = new StringTokenizer(br.readLine());
            N = Integer.parseInt(NMInputs.nextToken());
            M = Integer.parseInt(NMInputs.nextToken());

            int[][] fly = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    fly[i][j] = Integer.parseInt(input.nextToken());
                }
            }

            max = catchFly(fly, straightdi, straightdj, max);
            crossmax = catchFly(fly, crossdi, crossdj, crossmax);

            if(max > crossmax){
                System.out.println("#"+t+" "+max);
            } else {
                System.out.println("#"+t+" "+crossmax);
            }
        }
    }

    private static int catchFly(int[][] fly, int[] di, int[] dj, int mx) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = fly[i][j];
                for (int d = 0; d < 4; d++) {
                    for (int k = 1; k < M; k++) {
                        int ni = i + di[d]*k;
                        int nj = j + dj[d]*k;
                        if(ni >= 0 && ni < N && nj >= 0 && nj < N){
                            sum+=fly[ni][nj];
                        }
                    }
                } if(sum > mx){
                    mx = sum;
                }
            }
        }
        return mx;
    }
}