import java.util.Scanner;

public class PerfectShuffle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int T = sc.nextInt(); //케이스 수
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt(); //자연수 N
			
			String[] nums = new String[N]; //N개의 카드 이름
			
			for(int i = 0; i < N; i++) {
				nums[i] = sc.next();
			} //입력
			
			//시작 index 초기화
			int leftStartPoint = 0;
			int rightStartPoint = (N+1)/2;
			
			String[] result = new String[N];
			for(int i = 0; i < N; i++) {
				if(i%2 == 0) { //짝수에 해당한다는 뜻이니까 사이좋게 노나서 가지고
					result[i] = nums[leftStartPoint++];
				} else { //아니면 홀수라는 뜻이니까 넣어줘라~
					result[i] = nums[rightStartPoint++];
				}
			}
			System.out.println("#"+t+" "+String.join(" ", result));
		}
		
	}
	public static String input = "\r\n"
			+ "3\r\n"
			+ "6\r\n"
			+ "A B C D E F\r\n"
			+ "4\r\n"
			+ "JACK QUEEN KING ACE\r\n"
			+ "5\r\n"
			+ "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA\r\n";
}
