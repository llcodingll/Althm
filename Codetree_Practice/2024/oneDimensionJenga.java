import java.util.*;

public class oneDimensionJenga {
    public static void main(String[] args) {
        /* 입력 받기 */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jenga = new int[n];
        for(int i = 0; i<n; i++){
            jenga[i] = sc.nextInt();
        }
        int s1 = sc.nextInt()-1;
        int e1 = sc.nextInt()-1;
        int s2 = sc.nextInt()-1;
        int e2 = sc.nextInt()-1;

        int jengaLength = 0;
        
        for(int i = 0; i<n; i++){
            if(i>=s1 && i<=e1){
                jenga[i] = 0;
            }
            else{
                jengaLength++;
            }
        }

        int[] tmp = new int[jengaLength];
        int tmp_low = 0;

        for(int i = 0; i<n; i++){
            if(jenga[i]!=0){
                tmp[tmp_low] = jenga[i];
                tmp_low++;
            }
        }

        jengaLength=0;

        for(int i = 0; i<tmp.length; i++){
            if(i>=s2 && i<=e2){
                tmp[i] = 0;           
            }
            else{
                jengaLength++;
            }
        }
        System.out.println(jengaLength);
        for(int i = 0; i<tmp.length; i++){
            if(tmp[i]!=0){
                System.out.println(tmp[i]);
            }
        }
    }
}