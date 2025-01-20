import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {

		System.out.println("숫자 입력 >> ");
        Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= num; i++){
            if(i % 2 == 0) {
                sum += i;
                System.out.println("더한 값: "+sum);
            }
        }

        System.out.println("1부터 10까지 수 중 짝수의 합 = " + sum);
	}

}
