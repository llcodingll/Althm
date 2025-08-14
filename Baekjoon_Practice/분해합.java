import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        for(int i = 1; i<n; i++){
            int num = i;
            int sum = i;
            
            while(num != 0){
                sum += num%10;
                num /= 10;
            }
            if(n == sum){
                m = i;
                break;
            }
        }
        System.out.print(m);
        
    }
}