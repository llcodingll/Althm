
import java.util.Scanner;

public class SiderWeb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        //거미줄 가장 많이 친 횟수
        int maxWeb = 0;

        //거미줄 가장 많이 친 좌표
        int maxI = 0, maxJ = 0;

        //델타 배열(8방향)
        int[] delI = {1, -1, 0, 0, -1, 1, -1, 1};
        int[] delJ = {0, 0, -1, 1, 1, 1, -1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int web = map[i][j] == 0 ? 1 : 0;

                for (int k = 0; k < delJ.length; k++) {
                    for (int move = 1; move < n; move++) {
                        int nextI = i + delI[k] * move;
                        int nextJ = j + delJ[k] * move;

                        if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n){
                            break;
                        }

                        int beforeI = nextI - delI[k];
                        int beforeJ = nextJ - delJ[k];

                        if(map[nextI][nextJ] == 1 && map[beforeI][beforeJ] == 1){
                            break;
                        }

                        if(map[nextI][nextJ] == 0){
                            web++;
                        }
                    }
                }
                
                if(maxWeb < web){
                    maxWeb = web;

                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println(maxWeb);
        System.out.println(maxI +", "+maxJ);
    }
}
