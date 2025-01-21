import java.util.*;
import java.lang.*;

public class optimalCrossBomb {
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

    /* 동일한 숫자쌍의 개수를 세는 메서드 */
    public static int countPairNum(int[][] grid){
        // 각 격자 좌표에서 상,하,좌,우를 확인하여 동일한 숫자쌍을 찾음
        int pair = 0;
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(r>0 && grid[r][c]==grid[r-1][c] && grid[r][c]!=0){ //상
                    pair++;
                }
                if(r<grid.length-1 && grid[r][c]==grid[r+1][c] && grid[r][c]!=0){ //하
                    pair++;
                }
                if(c>0 && grid[r][c]==grid[r][c-1] && grid[r][c]!=0){ //좌
                    pair++;
                }
                if(c<grid.length-1 && grid[r][c]==grid[r][c+1] && grid[r][c]!=0){ //우
                    pair++;
                }
            }
        }
        pair /= 2; // 중복해서 센 숫자쌍 고려하여 2로 나눔

        return pair;
    }

    public static void arrayCopy(int[][] grid, int[][] tmpGrid){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                tmpGrid[i][j] = grid[i][j];
            }
        }
    }

    public static void main(String[] args) {
        // 입력값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int max = 0; //동일 숫자쌍 최댓값 저장할 변수
        int[][] tmpGrid = new int[n][n]; //완전 탐색에 활용할 2차원 배열 변수

        // 폭탄이 터진 후의 동일 숫자쌍 최댓값을 구하기 위해 격자 각 칸에 대해 완전 탐색 진행
        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                arrayCopy(grid, tmpGrid);//격자 값 초기화
                bang(tmpGrid, r, c);
                fallDown(tmpGrid);
                max = Math.max(max, countPairNum(tmpGrid)); // 숫자쌍 최댓값을 구함
            }
        }

        /* 결과 출력 */
        System.out.print(max);
    }
}