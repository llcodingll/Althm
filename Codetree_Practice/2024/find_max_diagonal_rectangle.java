import java.util.*;
import java.lang.*;

public class find_max_diagonal_rectangle {
    public static int getMax(int n, int[][]num){
        /* n*n 배열에 대해 순서대로 순회하며 직사각형의 시작점을 지정하고 직사각형을 그려 합 최댓값을 찾음 */

        //전체 최대 합
        int max = 0;

        //시작점 지정 및 직사각형 그리기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //비교를 위한 임시 최대 합(해당 지점의 직사각형 합 중 최대값)
                int tmp_max = getMaxRectangle(n, i, j, num);
                max = Math.max(max, tmp_max);
            }
        }

        return max;
    }

    public static int getMaxRectangle(int n, int row, int col, int[][]num){
        /* 좌표값(row, col)을 받아 해당 위치에서 가능한 직사각형을 모두 그려 최댓값을 찾음*/ 

        //해당 지점에서 그린 직사각형 중 최대 합
        int maxRectagleSum = 0;

        //직사각형에서 홀수번째(1번째, 3번째)에 그려지는 변 길이 odd, 짝수번째(2번째, 4번째)에 그려지는 변 길이 even
        //배열의 크기 n과 odd, even은 odd+even = n-1의 관계를 가짐
        for(int odd=1; odd<=n-2; odd++){
            for(int even=1; even+odd<=n-1; even++){
                //변의 길이를 넣어 직사각형을 그리고 최대 합을 구함 
                int rectangleSum = drawRectangle(n, row, col, num, odd, even);
                maxRectagleSum = Math.max(maxRectagleSum, rectangleSum);
            }
        }
        
        return maxRectagleSum;
    }

    public static int drawRectangle(int n, int row, int col, int[][]num, int odd, int even){
        /* 시작점 및 각 변의 길이를 받아 직사각형을 그려 합을 구함 */
        //x축, y축 이동 방향 순서대로 설정
        int[] x = {1, -1, -1, 1};
        int[] y = {-1, -1, 1, 1};

        //직사각형 합
        int rectangleSum = 0;

        //직사각형 그리기
        for(int i=0; i<4; i++){
            if(i==0 || i==2){
                for(int j=0; j<odd; j++){
                    if(row>=0&&row<=n-1&&col>=0&&col<=n-1){
                        rectangleSum+=num[row][col];
                        row += x[i];
                        col += y[i];
                    }
                    else{
                        rectangleSum=0;
                        break;
                    }
                }
            }
            else if(i==1 || i==3){q
                for(int j=0; j<even; j++){
                    if(row>=0&&row<=n-1&&col>=0&&col<=n-1){
                        rectangleSum+=num[row][col];
                        row += x[i];
                        col += y[i];
                    }
                    else{
                        rectangleSum=0;
                        break;
                    }
                }
            }
        }

        return rectangleSum;
    }

    public static void main(String[] args) {
        // input 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                num[i][j] = sc.nextInt();
            }
        }

        System.out.println(getMax(n, num));

    }
}