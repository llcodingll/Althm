
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BallAndWeeds {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String inputs = br.readLine();

            String[] ground = new String[inputs.length()];
            for (int i = 0; i < inputs.length(); i++) {
                ground[i] = String.valueOf(inputs.charAt(i));
            }

            int cnt = 0;
            for (int i = 0; i < ground.length; i++) {
                if (ground[i].equals("(")) {
                    int idx = i + 1;
                    if (idx < ground.length && !ground[idx].equals(")")) {
                        cnt++;
                    }
                }
                if (ground[i].equals(")")) {
                    cnt++;
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}
