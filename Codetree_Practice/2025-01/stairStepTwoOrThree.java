import java.io.*;
public class stairStepTwoOrThree {
    static int[] memo;

    public static int stair(int n){
        if(n<1) return 0;
        if(memo[n]!=0) return memo[n];
        else if(n<=4) memo[n] = 1;
        else memo[n] = (stair(n-2)+stair(n-3))%10007;

        return memo[n];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        stair(n);

        System.out.println(memo[n]);
    }
}