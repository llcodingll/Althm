import java.util.*;
import java.lang.*;

public class stackNumberMove {
    /* 방향을 나타내는 변수 - 순서 : 왼쪽상단, 상단, 오른쪽상단, 왼쪽, 오른쪽, 왼쪽하단, 아래쪽, 오른쪽하단 */
    static int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

    /* 격자 전체를 돌며 지정된 숫자를 찾아 이동시키는 메서드 */
    public static void move(LinkedList<Integer>[][] grid, int num){
        int curX = 0;
        int curY = 0;
        int curIdx = 0;

        // grid를 탐색하여 지정된 숫자를 찾음
        for(int x = 0; x<grid.length; x++){
            for(int y = 0; y<grid.length; y++){
                if(!grid[x][y].isEmpty() && grid[x][y].contains(num)){
                    // 지정된 숫자가 존재하는 격자 내 좌표
                    curX = x;
                    curY = y;

                    // linkedlist에서의 지정된 숫자의 인덱스
                    curIdx = grid[x][y].indexOf(num);
                }
            }
        }

        // 숫자를 찾으면, 그 숫자 주위를 탐색해서 최대인 숫자 쪽으로 이동함
        moveToMax(grid, curX, curY, curIdx);
        
    }

    /* 인접 칸 중 최대 숫자쪽으로 중앙 숫자를 이동시키는 메서드 */
    public static void moveToMax(LinkedList<Integer>[][] grid, int x, int y, int idx){
        int maxDirIdx = 0; // 최댓값이 존재하는 칸으로의 방향을 나타내는 인덱스
        int maxValue = 0; // 최댓값

        // 이동할 좌표값
        int nextX = 0;
        int nextY = 0;

        for(int i = 0; i<8; i++){
            nextX = x+dirX[i];
            nextY = y+dirY[i];

            if(nextX>=0 && nextX<=grid.length-1 && nextY>=0 && nextY<=grid.length-1){
                for(int j = 0; j<grid[nextX][nextY].size(); j++){
                    if(!grid[nextX][nextY].isEmpty() && maxValue<grid[nextX][nextY].get(j)){
                        maxValue = grid[nextX][nextY].get(j);
                        maxDirIdx = i;
                    }
                }
            }
        }

        nextX = x+dirX[maxDirIdx];
        nextY = y+dirY[maxDirIdx];

        // 인접한 여덟 방향에 숫자가 있는 경우에만 이동
        if(maxValue != 0){
            // 지정 숫자의 위에 쌓인 숫자도 이동
            for(int i = idx; i<grid[x][y].size(); i++){
                grid[nextX][nextY].add(grid[x][y].get(i));
            }
            for(int i = grid[x][y].size()-1; i>=idx; i--){
                grid[x][y].remove(i);
            }
        }
    }

    public static void main(String[] args) {
        // 사용자 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        LinkedList<Integer>[][] grid = new LinkedList[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = new LinkedList<Integer>();
                grid[i][j].add(sc.nextInt());
            }
        }

        int[] num = new int[m];
        for(int i = 0; i<m; i++){
            num[i] = sc.nextInt();
        }
        
        // 지정된 숫자 이동 (m번 반복)
        for(int i = 0; i<m; i++){
            move(grid, num[i]);
        }

        // 결과 출력
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j].isEmpty()){
                    System.out.println("None");
                }
                else{
                    for(int k = grid[i][j].size()-1; k>=0; k--){
                        System.out.print(grid[i][j].get(k)+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}