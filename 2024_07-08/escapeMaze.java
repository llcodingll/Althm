import java.util.*;

public class escapeMaze {
    //미로 탈출 메서드
    public static int move(char[][] maze, int x, int y){
        //이동 횟수를 기록할 변수
        int count = 0;

        //이동할 방향 변경(순서는 반시계 기준)
        int idx = 0;
        int[] dirX = {0, -1, 0, 1};
        int[] dirY = {1, 0, -1, 0};

        //방문 횟수를 확인할 2차원 배열
        int[][] isVisited = new int[maze.length][maze[0].length];
        
        while(true){
            //바라본 방향으로 이동 시 격자 밖인 경우
            if(x+dirX[idx]<0 || x+dirX[idx]>maze.length-1 || y+dirY[idx]<0 || y+dirY[idx]>maze[0].length-1){
                count++;
                break;
            }
            //바라본 방향으로 이동 불가능한 경우
            else if(maze[x+dirX[idx]][y+dirY[idx]]=='#'){
                idx = (idx+1)%4;
                isVisited[x][y]++;
                if(isVisited[x][y]>=4){
                    count = -1;
                    break;
                }
            }
            //바라본 방향으로 이동 가능하나, 격자 안인 경우
            else{
                //오른쪽에 짚을 벽이 있는 경우
                if(maze[x+dirX[idx]+dirX[(idx+3)%4]][y+dirY[idx]+dirY[(idx+3)%4]]=='#'){
                    if(isVisited[x][y]>=4){
                        count = -1;
                        break;
                    }
                    isVisited[x][y]++;
                    x = x+dirX[idx];
                    y = y+dirY[idx];
                    count++;
                }
                //짚을 벽이 없는 경우
                else if(maze[x+dirX[idx]+dirX[(idx+3)%4]][y+dirY[idx]+dirY[(idx+3)%4]]=='.'){
                    if(isVisited[x][y]>=4){
                        count = -1;
                        break;
                    }
                    isVisited[x][y]++;
                    x = x+dirX[idx];
                    y = y+dirY[idx];
                    count++;
                    idx = (idx+3)%4;
                    if(isVisited[x][y]>=4){
                        count = -1;
                        break;
                    }
                    isVisited[x][y]++;
                    x = x+dirX[idx];
                    y = y+dirY[idx];
                    count++;
                }
            }
        }

        return count; 
    }


    public static void main(String[] args) {
        // 입력값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;
        char[][] maze = new char[n][n];
        for(int i = 0; i<n; i++){
            String inputLine = sc.next();
            for(int j = 0; j<n; j++){
                maze[i][j] = inputLine.charAt(j);
            } 
        }

        // 미로 탈출에 걸리는 시간 구하기
        int count = move(maze, x, y);

        System.out.print(count);
    }
}