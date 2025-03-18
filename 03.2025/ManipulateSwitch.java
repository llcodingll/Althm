import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class ManipulateSwitch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
 
            int[] curr = new int[N];
            int[] after = new int[N];
 
            StringTokenizer currInput = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                curr[i] = Integer.parseInt(currInput.nextToken());
            }
 
            StringTokenizer afterInput = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                after[i] = Integer.parseInt(afterInput.nextToken());
            }
 
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                while (curr[i] != after[i]) {
                    for (int j = i; j < N; j++) {
                        switch (curr[j]) {
                            case 0:
                            curr[j] = 1;
                            break;
                            case 1:
                            curr[j] = 0;
                            break;
                            default:
                            break;
                        }
                    }
                    cnt++;
                }
            }
 
            System.out.println("#"+t+" "+cnt);
        }
    }
}