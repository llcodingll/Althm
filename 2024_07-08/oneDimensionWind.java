import java.util.*;
public class oneDimensionWind {

    /* 위치와 방향을 받아 밀고 전파 시키는 함수 (재귀 함수) */
    public static void push(int row, String direction, int[][] matrix, boolean isSpread, boolean isUp){
        int tmp; // 맨 끝 원소 값 임시 저장할 변수

        //바람 부는 방향 확인
        if(direction.equals("R")){ //오른쪽에서 바람이 부는 경우, 왼쪽 방향으로 밈
            tmp = matrix[row][0];
            for(int i = 0; i<matrix[0].length-1; i++){
                matrix[row][i] = matrix[row][i+1];
            }
            matrix[row][matrix[0].length-1] = tmp;
        }
        else{ //왼쪽에서 바람이 부는 경우, 오른쪽 방향으로 밈
            tmp = matrix[row][matrix[0].length-1];
            for(int i = matrix[0].length-1; i>0; i--){
                matrix[row][i] = matrix[row][i-1];
            }
            matrix[row][0] = tmp;
        }

        //바람으로 인해 직접적으로 밀린 것인지 판단 후 전파 여부 판단
        boolean isUpperLineSame = false;
        boolean isLowerLineSame = false;
        //바람에 의해 직접적으로 밀린 경우
        if(!isSpread){
            for(int i = 0; i<matrix[0].length; i++){//윗 줄 비교
                if(row<=0){
                    break;
                }
                else if(matrix[row][i] == matrix[row-1][i]){
                    isUpperLineSame = true;
                    break;
                }
            }
            if(isUpperLineSame){
                if(direction.equals("R")){
                    push(row-1, "L", matrix, true, true);
                }
                else{
                    push(row-1, "R", matrix, true, true);
                }
            }
            for(int i = 0; i<matrix[0].length; i++){//아랫 줄 비교
                if(row>=matrix.length-1){
                    break;
                }
                else if(matrix[row][i] == matrix[row+1][i]){
                    isLowerLineSame = true;
                    break;
                }
            }
            if(isLowerLineSame){
                if(direction.equals("R")){
                    push(row+1, "L", matrix, true, false);
                }
                else{
                    push(row+1, "R", matrix, true, false);
                }
            }
        }
        //전파되고 있는 경우
        else{
            //방향 파악
            if(isUp){
                for(int i = 0; i<matrix[0].length; i++){//윗 줄 비교
                    if(row<=0){
                        break;
                    }
                    else if(matrix[row][i] == matrix[row-1][i]){
                        isUpperLineSame = true;
                        break;
                    }
                }
                if(isUpperLineSame){
                    if(direction.equals("R")){
                        push(row-1, "L", matrix, true, true);
                    }
                    else{
                        push(row-1, "R", matrix, true, true);
                    }
                }
            }
            else{
                for(int i = 0; i<matrix[0].length; i++){//아랫 줄 비교
                    if(row>=matrix.length-1){
                        break;
                    }
                    else if(matrix[row][i] == matrix[row+1][i]){
                        isLowerLineSame = true;
                        break;
                    }
                }
                if(isLowerLineSame){
                    if(direction.equals("R")){
                        push(row+1, "L", matrix, true, false);
                    }
                    else{
                        push(row+1, "R", matrix, true, false);
                    }
                }
            }
        }

        
        
    }

    public static void main(String[] args) {
        /* 입력값 입력받기 */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] matrix = new int [n][m];
        int[] windRow = new int[q];
        String[] windDirection = new String[q];
        //행렬 입력
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        //바람 입력
        for(int i = 0; i<q; i++){
            windRow[i]=sc.nextInt()-1;
            windDirection[i] = sc.next();
        }

        //바람을 행렬에 적용
        for(int i = 0; i<q; i++){
            push(windRow[i], windDirection[i], matrix, false, false);
        }

        //행렬 출력
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}