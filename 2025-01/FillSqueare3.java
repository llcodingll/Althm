import java.io.*;

public class FillSqueare3 {
    static int n;
    static double[] memo;

    public static double fillSquare(int num){
        if(num<0) return 0;
        if(memo[num]!=0) return memo[num];
        if(num<=2){
            if(num==0) memo[num] = 1;
            if(num==1) memo[num] = 2;
            if(num==2) memo[num] = 7;
        }
        else {
            double sum = 0;
            for(int i = 3; i<=num; i++){
                sum += fillSquare(num-i);
            }
            memo[num] = (fillSquare(num-1)*2+fillSquare(num-2)*3+sum*2)%1000000007;
        }
        return memo[num];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new double[n+1];
        System.out.print((int)fillSquare(n));
    }
}
