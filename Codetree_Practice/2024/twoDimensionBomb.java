import java.util.*;

public class twoDimensionBomb {
    /* 열 방향으로 m개 이상 연속되는지 확인하고 한 번에 모두 터트리는 메서드 */
    public static boolean bang(int[][] grid, int m){
        boolean isBang = false;
        for(int i = 0; i < grid[0].length; i++) {
            int count = 1;
            for(int j = 0; j < grid.length; j++){
                if (j < grid.length-1 && grid[j][i] != 0 && grid[j][i] == grid[j+1][i]) {
                    count++;
                } 
                else {
                    if(grid[j][i] != 0 && count >= m){
                        for (int k = 0; k < count; k++) {
                            grid[j-k][i] = 0; // 터진 폭탄 표시
                        }
                        isBang = true;
                    }
                    count = 1;
                }
            }
        }
        return isBang;
    }

    /* 폭탄이 터진 이후 떨어지게 하는 메서드 */
    public static void fallDown(int[][] grid){
        for(int i = 0; i < grid[0].length; i++) {
            int idx = grid.length - 1;
            for(int j = grid.length - 1; j >= 0; j--){
                if (grid[j][i] != 0) {
                    grid[idx][i] = grid[j][i];
                    if (idx != j) grid[j][i] = 0; // 값이 내려간 자리는 0으로 설정
                    idx--;
                }
            }
        }
    }

    /* 시계방향으로 90도 돌리는 메서드 */
    public static void rotate(int[][] grid){
        int n = grid.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[n - j - 1][i];
                grid[n - j - 1][i] = grid[n - i - 1][n - j - 1];
                grid[n - i - 1][n - j - 1] = grid[j][n - i - 1];
                grid[j][n - i - 1] = temp;
            }
        }
    }

    /* 모든 폭탄이 다 터졌는지 체크하는 메서드 */

    public static void main(String[] args) {
        // 입력값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // k번 만큼 회전 반복
        for(int i = 0; i<k; i++){
            while(bang(grid, m)){
                if(n>1){
                    fallDown(grid);
                }
            }
            rotate(grid);
            if(n>1){
                fallDown(grid);
            }
        }

        // 회전 이후 남은 폭탄 터트리기
        while(bang(grid, m)){
            fallDown(grid);
        }

        // 최종 결과 계산
        int bombCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    bombCount++;
                }
            }
        }
        System.out.print(bombCount);
    }
}