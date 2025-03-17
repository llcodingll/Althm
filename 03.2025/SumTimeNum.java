import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SumTimeNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int G = Integer.parseInt(br.readLine());
    
            int cnt = 0;
            List<Integer> time = new ArrayList<>();
            for (int hi = 0; hi < 3; hi++) {
                for (int hj = 0; hj < 5; hj++) {
                    for (int mi = 0; mi < 6; mi++) {
                        for (int mj = 0; mj < 10; mj++) {
                            for (int si = 0; si < 6; si++) {
                                for (int sj = 0; sj < 10; sj++) {
                                    if(G == hi+hj+mi+mj+si+sj){
                                        cnt++;
                                        time.add(hi);
                                        time.add(hj);
                                        time.add(mi);
                                        time.add(mj);
                                        time.add(si);
                                        time.add(sj);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if(cnt != 0){
                System.out.println(cnt);            
                for (int i = 0; i < time.size(); i+=6) {
                    for (int j = i; j < i+6; j+=2) {
                        for (int k = j; k < j+2; k++) {
                            System.out.print(time.get(k));
                        }
                        if(j < i+4){
                            System.out.print(":");
                        }                  
                    }
                    System.out.println();
                }
            } else {
                System.out.println(-1);
            }

        }
    }
}