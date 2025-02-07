import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] v = new int[N];
            for (int i = 0; i < N; i++) {
                v[i] = sc.nextInt();
            }
            
            int max = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < N-M+1; i++) {
                for (int j = i; j < i+M; j++) {
                    sum += v[j];
                }
                if(sum > max){
                    max = sum;
                }
                if(sum < min){
                    min = sum;
                }
                sum = 0;
            }
            System.out.println("#"+tc+" "+(max-min));
        }
    }
}
