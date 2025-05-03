import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);
        int[] result = new int[N];
        for (int i = 0; i < N-1; i++) {
            int tmp = times[i];
            if(i >= 1){
                result[i] = result[i-1]+times[i+1];
            } else {
                result[i] = tmp+times[i+1];
            }
        }

        int min = times[0];
        for (int i = 0; i < N; i++) {
            min+=result[i];
        }

        System.out.println(min);
    }
}