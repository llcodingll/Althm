import java.util.Scanner;

public class Season2_while {

	public static void main(String[] args) {
		System.out.println("월 입력>>");

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		String season = "";
		while(m<=12&&m>=1){
			switch(m){
                case 12, 1, 2:
                    season = "겨울";
                    break;
                case 3, 4, 5:
                    season = "봄";
                    break;
                case 6, 7, 8:
                    season = "여름";
                    break;
                case 9, 10, 11:
                    season = "가을";
                    break;
		    }
		    System.out.println(m+"월은 "+season+"입니다.");
            break;
	    }

    }
}
