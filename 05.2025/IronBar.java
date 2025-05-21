import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class IronBar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            int pieces = 0;

            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if (current == '(') {
                    stack.push('(');
                } else {
                    stack.pop();
                    if (input.charAt(i - 1) == '(') {
                        pieces += stack.size();
                    } else {
                        pieces += 1;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(pieces).append("\n");
        }
        System.out.print(sb.toString());
    }
}