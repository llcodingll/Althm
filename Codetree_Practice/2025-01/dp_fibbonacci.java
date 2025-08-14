import java.io.*;
public class dp_fibbonacci {
    static int[] memo;

    public static int fibbo(int n){
        if(memo[n] != 0) return memo[n];
        if(n<=2) memo[n] = 1;
        else memo[n] = fibbo(n-1)+fibbo(n-2);

        return memo[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        memo = new int[n+1];
        fibbo(n);

        System.out.println(memo[n]);
    }
}