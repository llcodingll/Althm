// 나머지의 재귀함수

import java.io.*;

public class Main{
    static int n;
    static int[] memo;
    public static int recursive(int num){
        if(memo[num]!=0) return memo[num];
        if(num <= 1) {
            if(num == 0) memo[num] = 2;
            if(num == 1) memo[num] = 4;
        }
        else memo[num] = (recursive(num-1)*recursive(num-2))%100;
        return memo[num];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        memo = new int[n];

        System.out.print(recursive(n-1));
    }
}