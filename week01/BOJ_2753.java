import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class BOJ_2753 {
 
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int y = Integer.parseInt(br.readLine());
		
		System.out.print((y%4==0)?((y%400==0)?"1":(y%100==0)?"0":"1"):"0");
	}
}