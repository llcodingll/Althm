
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PermutationCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    for (int k = 1; k <= N; k++) {
                        if (k != j && k != i && i + j + k == S) {
                            cnt++;
                            arr.add(i);
                            arr.add(j);
                            arr.add(k);
                        }
                    }
                }
            }
        }
        if (cnt != 0) {
            System.out.println(cnt);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
                for (int j = i + 1; j < i + 3; j++) {
                    System.out.print(arr.get(j) + " ");
                    if (j == i + 2) {
                        System.out.println();
                        i = i + 2;
                        break;
                    }
                }
            }
        } else {
            System.out.println(1);
        }
    }
}
