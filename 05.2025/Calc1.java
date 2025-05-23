import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Calc1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int length = Integer.parseInt(br.readLine());
            String infix = br.readLine();

            StringBuilder postfix = new StringBuilder();
            Stack<Character> operatorStack = new Stack<>();

            for (int i = 0; i < infix.length(); i++) {
                char ch = infix.charAt(i);
                if (Character.isDigit(ch)) {
                    postfix.append(ch);
                } else if (ch == '+') {
                    while (!operatorStack.isEmpty()) {
                        postfix.append(operatorStack.pop());
                    }
                    operatorStack.push(ch);
                }
            }

            while (!operatorStack.isEmpty()) {
                postfix.append(operatorStack.pop());
            }

            Stack<Integer> calcStack = new Stack<>();
            for (int i = 0; i < postfix.length(); i++) {
                char ch = postfix.charAt(i);
                if (Character.isDigit(ch)) {
                    calcStack.push(ch - '0');
                } else if (ch == '+') {
                    int b = calcStack.pop();
                    int a = calcStack.pop();
                    calcStack.push(a + b);
                }
            }
            int result = calcStack.pop();
            System.out.println("#" + t + " " + result);
        }
    }
}