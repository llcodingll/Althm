
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class BracketValidator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        bracketMap.put('>', '<');

        for (int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (int i = 0; i < len; i++) {
                char ch = input.charAt(i);

                if (bracketMap.containsValue(ch)) {
                    stack.push(ch);
                } else if (bracketMap.containsKey(ch)) {
                    if (!stack.isEmpty() && Objects.equals(stack.peek(), bracketMap.get(ch))) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            sb.append("#").append(t).append(" ").append(isValid ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }
}
