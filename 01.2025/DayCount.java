import java.util.Scanner;

public class DayCount {

	public static void main(String[] args) {
		//코드를 작성하세요.
		System.out.println("월과 일을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int d = sc.nextInt();
		//3, 5, 7, 8, 10, 12 =31일
		//2 = 28일
		//4,6,9,11 = 30일
		int c = d;
		for(int i = m-1; i > 0; i--) {
			if (i==2) {
				c+=28;
				System.out.println(c+".1");
			}else if ((i<8&&i%2==0)||(i>8&&i%2!=0)) {
				c+=30;
				System.out.println(c+".2");
			}else {
				c+=31;
				System.out.println(c+".3");
			}
		}

		System.out.println(m+"월 "+d+"일은 "+c+"번째 날입니다.");
	}

}

