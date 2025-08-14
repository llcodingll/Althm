import java.util.*;

public class twoDimensionWind {
    /* 범위를 입력받아 시계방향으로 이동 */
    public static void windPush(int[][] subMatrix, int[]wind){
        //범위 입력
        int r1=wind[0];
        int c1=wind[1];
        int r2=wind[2];
        int c2=wind[3];
        
        //각 줄 밀때 맨 끝 값 저장해줄 변수
        int tmpTop;
        int tmpBottom;

        //위쪽 줄 밀기
        tmpTop = subMatrix[r1][c2];
        for(int i = c2; i>c1; i--){
            subMatrix[r1][i] = subMatrix[r1][i-1];
        }
        //아래쪽 줄 밀기
        tmpBottom = subMatrix[r2][c1];
        for(int i = c1; i<c2; i++){
            subMatrix[r2][i] = subMatrix[r2][i+1];
        }
        //오른쪽 줄 밀기
        for(int i = r2; i>r1+1; i--){
            subMatrix[i][c2] = subMatrix[i-1][c2];
        }
        subMatrix[r1+1][c2] = tmpTop;
        //왼쪽 줄 밀기
        for(int i = r1; i<r2-1; i++){
            subMatrix[i][c1] = subMatrix[i+1][c1];
        }
        subMatrix[r2-1][c1] = tmpBottom;
    }

    /* 평균 계산해서 넣기 */
    public static void getAverage(int[][] subMatrix, int[][] mainMatrix, int[]wind){
        //범위 입력
        int r1=wind[0];
        int c1=wind[1];
        int r2=wind[2];
        int c2=wind[3];

        for(int i = r1; i<=r2; i++){
            for(int j = c1; j<=c2; j++){
                int sum = subMatrix[i][j]; //합(자기 자신 포함)
                int count = 1; //평균 낼 때 사용된 수의 개수(자기 자신 포함)

                //상하좌우 존재 여부 파악
                if(i>0){//위쪽 줄이 존재하면
                    sum+=subMatrix[i-1][j];
                    count++;
                }
                if(i<subMatrix.length-1){//아래쪽 줄이 존재하면
                    sum+=subMatrix[i+1][j];
                    count++;
                }
                if(j>0){//왼쪽 줄이 존재하면
                    sum+=subMatrix[i][j-1];
                    count++;
                }
                if(j<subMatrix[0].length-1){//오른쪽 줄이 존재하면
                    sum+=subMatrix[i][j+1];
                    count++;
                }

                //평균 계산
                mainMatrix[i][j] = sum / count;
            }
        }
    }

    /* subMatrix의 값들을 mainMatrix의 값들로 초기화 */
    // 한 번 바람이 분 것에 대한 모든 변화가 완료된 후에도 사용
    public static void initMatrix(int[][] subMatrix, int[][] mainMatrix){
        for(int i = 0; i<mainMatrix.length; i++){
            for(int j =0; j<mainMatrix[0].length; j++){
                subMatrix[i][j] = mainMatrix[i][j];
            }
        }
    }

    public static void main(String[] args) {
        /* 입력값 받기 */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행의 크기
        int m = sc.nextInt(); // 열의 크기
        int q = sc.nextInt(); // 바람 부는 횟수
        int[][] mainMatrix = new int[n][m]; // 기본 행렬
        int[][] subMatrix = new int[n][m]; // 바람 분 직후 값 저장할 부 행렬 : 평균 내는 과정에서 사용
        int[][] wind = new int[q][4]; // 바람 부는 범위 정보
        // 기본 행렬의 입력값 받기
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                mainMatrix[i][j] = sc.nextInt();
            }
        }
        
        // 바람 부는 범위 정보 입력값 받기
        for(int i = 0; i<q; i++){
            for(int j = 0; j<4; j++){
                wind[i][j] = sc.nextInt()-1;
            }
        }
        
        // 바람 적용
        for(int i = 0; i<q; i++){
            initMatrix(subMatrix, mainMatrix);//subMatrix를 mainMatrix로 초기화
            windPush(subMatrix, wind[i]);
            getAverage(subMatrix, mainMatrix, wind[i]);
        }

        // 행렬 출력
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                System.out.print(mainMatrix[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}