
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0) {
                    stack.pop();
                } else {
                    stack.push(num);
                }
            }
            int sum = 0;
            for (int val : stack) {
                sum += val;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.toString());
    }
}
