import java.util.*;

public class twoThousandFoutyEight {
    /* 왼쪽으로 미는 메서드 */
    public static void pushLeft(int[][] grid){
        for(int i = 0; i<4; i++){
            int[] tmp = new int[4];
            int idx = 3;
            boolean isPlus = false;
            for(int j = 0; j<4; j++){
                if(grid[i][j] != 0){
                    if(idx<3 && grid[i][j] == tmp[idx+1] && !isPlus){
                        tmp[idx+1]+= grid[i][j];
                        isPlus = true;
                    }
                    else{
                        tmp[idx] = grid[i][j];
                        idx--;
                    }
                }
            }
            for(int j = 0; j<4; j++){
                grid[i][j] = tmp[3-j];
            }
        }
    }

    /* 오른쪽으로 미는 메서드 */
    public static void pushRight(int[][] grid){
        for(int i = 0; i<4; i++){
            int[] tmp = new int[4];
            int idx = 3;
            boolean isPlus = false;
            for(int j = 3; j>=0; j--){
                if(grid[i][j] != 0){
                    if(idx<3 && grid[i][j] == tmp[idx+1] && !isPlus){
                        tmp[idx+1]+= grid[i][j];
                        isPlus = true;
                    }
                    else{
                        tmp[idx] = grid[i][j];
                        idx--;
                    }
                }
            }
            for(int j = 0; j<4; j++){
                grid[i][j] = tmp[j];
            }
        }
    }

    /* 위쪽으로 미는 메서드 */
    public static void pushUp(int[][] grid){
        for(int i = 0; i<4; i++){
            int[] tmp = new int[4];
            int idx = 3;
            boolean isPlus = false;
            for(int j = 0; j<4; j++){
                if(grid[j][i] != 0){
                    if(idx<3 && grid[j][i] == tmp[idx+1] && !isPlus){
                        tmp[idx+1]+= grid[j][i];
                        isPlus = true;
                    }
                    else{
                        tmp[idx] = grid[j][i];
                        idx--;
                    }
                }
            }
            for(int j = 0; j<4; j++){
                grid[j][i] = tmp[3-j];
            }
        }
    }

    /* 아래쪽으로 미는 메서드 */
    public static void pushDown(int[][] grid){
        for(int i = 0; i<4; i++){
            int[] tmp = new int[4];
            int idx = 3;
            boolean isPlus = false;
            for(int j = 3; j>=0; j--){
                if(grid[j][i] != 0){
                    if(idx<3 && grid[j][i] == tmp[idx+1] && !isPlus){
                        tmp[idx+1]+= grid[j][i];
                        isPlus = true;
                    }
                    else{
                        tmp[idx] = grid[j][i];
                        idx--;
                    }
                }
            }
            for(int j = 0; j<4; j++){
                grid[j][i] = tmp[j];
            }
        }
    }

    public static void main(String[] args) {
        /* 입력 값 받기 */
        int[][] grid = new int[4][4];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        String dir = sc.next();

        switch(dir){
            case "L":
                pushLeft(grid);
                break;
            case "R":
                pushRight(grid);
                break;
            case "U":
                pushUp(grid);
                break;
            case "D":
                pushDown(grid);
                break;
        }

        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
