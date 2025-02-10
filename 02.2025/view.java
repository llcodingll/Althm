import java.util.Scanner;

public class view {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
             
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();  
            }
            int count = 0;
            for(int i = 0; i < N-4; i++) {
                int mid = arr[i+2];
                int mx = 0;
                for(int j = i; j <= i+4; j++) {
                    if(j == i+2) {
                    }
                    else if(arr[j] > mx) {
                        mx = arr[j];
                    }
                }
                if(mid-mx > 0) {
                    count += mid-mx;
                }
                 
            }
             
            System.out.println("#"+tc+" "+count);
        }
    }
}
