// 흥미로운 숫자

import java.util.*;
import java.io.*;

public class Main {
    static int x;
    static int y;
    static int ans = 0;

    public static void findInterestingNumber() {
        for(int i = x; i <= y; i++) {
            int number = i;
            ArrayList<Integer> num = new ArrayList<>();
            while(number != 0){
                num.add(number%10);
                number /= 10;
            }

            int mark1 = num.get(0);
            int mark2 = -1;
            int count1 = 1;
            int count2 = 0;
            for(int j = 1; j<num.size(); j++){
                if(num.get(j) == mark1) count1++;
                else if(num.get(j) == mark2) count2++;
                else{
                    if(mark2 == -1) {
                        mark2 = num.get(j);
                        count2++;
                    }
                    else{
                        break;
                    }
                }
            }
            if(count1+count2 == num.size()){
                if(count1 == 1 || count2 == 1) ans++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        findInterestingNumber();

        System.out.print(ans);
    }
}