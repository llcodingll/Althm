import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] grid = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++){
                if(input.charAt(j) == '*') grid[i][j] = true;
            }
        }

        int heartRow = 0;
        int heartCol = 0;

        // Find heart position - should have * in center and all 4 directions
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < n-1; j++){
                if(grid[i][j] && grid[i-1][j] && grid[i][j-1] && grid[i+1][j] && grid[i][j+1]){
                    heartRow = i + 1; // Convert to 1-indexed
                    heartCol = j + 1; // Convert to 1-indexed
                    break;
                }
            }
        }

        // Convert back to 0-indexed for calculations
        int hRow = heartRow - 1;
        int hCol = heartCol - 1;

        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        // Calculate left arm length
        for(int j = hCol - 1; j >= 0; j--){
            if(grid[hRow][j]) leftArm++;
            else break;
        }

        // Calculate right arm length
        for(int j = hCol + 1; j < n; j++){
            if(grid[hRow][j]) rightArm++;
            else break;
        }

        // Calculate waist length
        int waistEnd = hRow;
        for(int i = hRow + 1; i < n; i++){
            if(grid[i][hCol]) {
                waist++;
                waistEnd = i;
            }
            else break;
        }

        // Calculate left leg length (starts from below waist)
        for(int i = waistEnd + 1; i < n; i++){
            if(grid[i][hCol - 1]) leftLeg++;
            else break;
        }

        // Calculate right leg length (starts from below waist)
        for(int i = waistEnd + 1; i < n; i++){
            if(grid[i][hCol + 1]) rightLeg++;
            else break;
        }

        System.out.println(heartRow + " " + heartCol);
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}