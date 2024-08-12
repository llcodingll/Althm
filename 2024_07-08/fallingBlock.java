import java.util.*;

public class fallingBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt()-1;
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i<n; i++){
            boolean isBlock = false;
            for(int j = k; j<k+m; j++){
                if(grid[i][j] == 1){
                    isBlock = true;
                    break;
                }
            }
            if(isBlock){
                for(int j = k; j<k+m; j++){
                    grid[i-1][j] = 1;
                }
                break;
            }
            if(i==n-1){
                for(int j = k; j<k+m; j++){
                    grid[i][j] = 1;
                }
                break;
            }
        }
        if(n==1){
            grid[0][0] = 1;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}