import java.util.Scanner;

public class Season1_for {

	public static void main(String[] args) {
		System.out.println("월 입력>>");

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		String season = "";
		for(int i = 1; (i <= m && i <= 12); i++){
			if((m>=3&&m<=5)){
				season = "봄";
			}else if ((m>=6&&m<=8)) {
				season = "여름";
			}else if((m>=9&&m<=11)){
				season = "가을";
			}else {
				season = "겨울";
			}
		}
		System.out.println(m+"월은 "+season+"입니다.");
	}

}
