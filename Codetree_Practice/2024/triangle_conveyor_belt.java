import java.util.*;

public class triangle_conveyor_belt {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] num = new int[3*n];

        for(int i=0; i<3*n; i++){
            num[i] = sc.nextInt();
        }

        for(int i=0; i<t; i++){
            int tmp = num[3*n-1];
            for(int j=3*n-1; j>0; j--){
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
        System.out.println();
        for(int i=2*n; i<3*n; i++){
            System.out.print(num[i]+" ");
        }
    }
}