import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int number = 666;
        
        while(n!=count){
            number++;
            if(String.valueOf(number).contains("666")){
                count++;
            }
        }
        
        System.out.print(number);
        
    }
}