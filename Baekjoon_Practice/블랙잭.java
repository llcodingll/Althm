import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int [] num = new int[n];
        int min = 300000;
        
        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int sum = num[i]+num[j]+num[k];
                    if(m>=sum && Math.abs(m-min) > Math.abs(m-sum)){
                        min = sum;
                    }
                }
            }
        }
        System.out.print(min);
        
    }
}