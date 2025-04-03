
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_NAndM6 {

    static int N, M;
    static int[] nums, arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        nums = new int[N];
        StringTokenizer input = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(nums);

        arr = new int[M];
        simulate(0, 0);
    }

    static void simulate(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                simulate(start + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
