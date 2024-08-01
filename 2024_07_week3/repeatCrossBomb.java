import java.util.*;

public class repeatCrossBomb {
    /* 격자의 숫자를 확인하여 폭탄 터질 범위를 산정하고, 해당 범위를 0으로 만드는 메서드 */
    public static void bang(int[][] grid, int r, int c){
        int splash = grid[r][c]-1;//폭탄 상하좌우 범위
        //폭탄 터진 부분 0으로 만들기
        for(int i = r-splash; i<=r+splash; i++){
            if(i>=0 && i<=grid.length-1){
                grid[i][c] = 0;
            }
        }
        for(int i = c-splash; i<=c+splash; i++){
            if(i>=0 && i<=grid.length-1){
                grid[r][i] = 0;
            }
        }
    }

    /* 열 마다 체크하여 중력 적용, 내려앉게 만들기 */
    public static void fallDown(int[][] grid){    
        for(int i = 0; i<grid.length; i++){
            int[] tmp = new int[grid.length];
            int k = grid.length-1;
            for(int j = grid.length-1; j>=0; j--){
                if(grid[j][i]!=0){
                    tmp[k] = grid[j][i];
                    k--;
                }
            }
            for(int j = 0; j<grid.length; j++){
                grid[j][i] = tmp[j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int[] column = new int[m];
        for(int i = 0; i<m; i++){
            column[i] = sc.nextInt()-1;
        }

        for(int i = 0; i<m; i++){
            int c = column[i];
            int r = 0;
            //선택된 열의 가장 첫 번째 행부터 순차적으로 0이 아닌 행 탐색
            for(int j =0; j<n; j++){
                if(grid[j][c] != 0){
                    r = j;
                    break;
                }
            }
            bang(grid, r, c);
            fallDown(grid);
        }

        /* 결과 출력 */
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}