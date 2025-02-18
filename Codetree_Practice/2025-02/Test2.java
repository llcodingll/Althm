//최대 H 점수 2

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int l;
    static int[] num;
    static int ans = 1;

    public static void findHPoint(){
        for(int i = 1; i<=100; i++){
            int count = 0;
            int canAdd = 0;
            for(int j = 0; j<n; j++){
                if(num[j] >= i) count++;
                else if(num[j]+1 >= i){
                    if(canAdd < l){
                        canAdd++;
                        count++;
                    }
                }
            }
            if(i <= count) ans = Math.max(ans, i);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        findHPoint();
        System.out.print(ans);
    }
}