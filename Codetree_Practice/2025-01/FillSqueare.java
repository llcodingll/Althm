import java.io.*;

public class FillSqueare {
    static int n;
    static int[] memo;
    public static int fillSquare(int num){
        if(num<=0) return 0;
        if(memo[num] != 0) return memo[num];
        if(num <= 2){
            if(num == 1) memo[num] = 1;
            if(num == 2) memo[num] = 2;
        }
        else{
            memo[num] = (fillSquare(num-1) + fillSquare(num-2))%10007;
        }

        return memo[num];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        System.out.print(fillSquare(n));
    }
}
