import java.util.*;
import java.lang.*;

public class dig_gold {
    //n에 따른 최대 k값 구하기(k값 : 마름모 크기에 영향을 주는 값, 마름모의 크기는 k*k + (k+1)+(k+1)임)
    public static int getMaxK(int n){
        if(n%2==0){
            return n;
        }
        else{
            return n-1;
        }
    }

    //해당 좌표를 중심으로 둔 경우의 최대 금값 구하기
    public static int maxGold(int[][] num, int row, int col, int n, int m){
        int max_k = getMaxK(n);
        int max = 0;
        //가능한 k 값 모두 적용
        for(int k = 0; k<=max_k; k++){
            int gold_num = digRhombus(num, row, col, n, k);
            int gold_value = gold_num*m;
            int dig_value = (k*k)+(k+1)*(k+1);
            if(gold_value>=dig_value){
                max = Math.max(max, gold_num);
            }
        }
        return max;
    }

    //마름모 모양으로 탐색
    public static int digRhombus(int[][] num, int row, int col, int n, int k){
        int countGold = 0;
        int x, y;
        for(int i=-k; i<=k; i++){
            int abs_i = Math.abs(i);
            for(int j=abs_i-k; j<=k-abs_i; j++){
                x=row+i;
                y=col+j;
                if(x>=0&&x<n&&y>=0&&y<n){
                    countGold+=num[x][y];
                }
            }
        }
        return countGold;
    }

    public static void main(String[] args) {
        //입력값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                num[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        
        //각 좌표를 중심으로 하는 마름모 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp_max = maxGold(num, i, j, n, m);
                max = Math.max(max, tmp_max);
            }
        }

        //최댓값 출력
        System.out.println(max);
        
    }
}