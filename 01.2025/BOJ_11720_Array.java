import java.util.Scanner;

public class BOJ_11720_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            sum+=nums[i];
        }
        System.out.println(sum);

    }
}