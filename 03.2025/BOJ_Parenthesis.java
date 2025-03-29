
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_Parenthesis {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(findPair(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String findPair(String parenthesis) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < parenthesis.length(); i++) {

            char curr = parenthesis.charAt(i);

            if (curr == '(') {
                stack.push(curr);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
