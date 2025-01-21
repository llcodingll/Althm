import java.util.*;

public class coveyor_belt_basic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] num = new int[2*n];

        for(int i = 0; i<2*n; i++){
            num[i] = sc.nextInt();
        }
        
        for(int i = 0; i<t; i++){
            int tmp = num[2*n-1];
            for(int j = 2*n-1; j>0; j--){
                num[j] = num[j-1];
            }
            num[0] = tmp;
        }

        for(int i=0; i<n; i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
        for(int i=n; i<2*n; i++){
            System.out.print(num[i]+" ");
        }
    }
}