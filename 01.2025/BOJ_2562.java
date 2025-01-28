
import java.util.Scanner;

public class BOJ_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { sc.nextInt(), sc.nextInt(), sc.nextInt(),
            sc.nextInt(), sc.nextInt(), sc.nextInt(),
            sc.nextInt(), sc.nextInt(), sc.nextInt() };
        
        int count = 0;
        int max = 0;
        int idx = 0;

        for(int value : arr) {
			count++;
            
			if(value > max) {
				max = value;
				idx = count;
			}
		}
		System.out.print(max + "\n" + idx);
    }
}
