import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        
        int x = (c*e - f*b)/(a*e - d*b);
        int y = (c*d - f*a)/(b*d - e*a);
        
        System.out.print(x+" "+y);
        
    }
}