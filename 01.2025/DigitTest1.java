public class DigitTest1 {
	//DigitTest1
	public static void main(String[] args) {
		
		/*
		  *****
		   ****
		    ***
		     **
		      *
		 */

		 int n = 5;
		 int count = 0;
		 for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n-i; j++) {
				System.out.printf("%-3d", count);
				count++;
			}
			System.out.println();
		 }
	}
}
