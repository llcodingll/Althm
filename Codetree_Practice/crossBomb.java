import java.util.*;

public class crossBomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int m = grid[r][c]-1;//폭탄 상하좌우 범위

        //폭탄 터진 부분 0으로 만들기
        for(int i = r-m; i<=r+m; i++){
            if(i>=0 && i<=n-1){
                grid[i][c] = 0;
            }
        }
        for(int i = c-m; i<=c+m; i++){
            if(i>=0 && i<=n-1){
                grid[r][i] = 0;
            }
        }

        //열마다 체크, 중력 적용하여 내려앉게 만들기
        for(int i = 0; i<n; i++){
            int[] tmp = new int[n];
            int k = n-1;
            for(int j = n-1; j>=0; j--){
                if(grid[j][i]!=0){
                    tmp[k] = grid[j][i];
                    k--;
                }
            }
            for(int j = 0; j<n; j++){
                grid[j][i] = tmp[j];
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}