import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char [][] board = new char [n][m];
        
        int min = 64;
        
        for(int i = 0; i<n; i++){
            String line = sc.nextLine();
            for(int j = 0; j<m; j++){
                board[i][j] = line.charAt(j);
            }
        }
        
        for(int i = 0; i<=n-8; i++){
            for(int j = 0; j<=m-8;j++){
                min = Math.min(min, countRePaint(i, j, board));
            }
        }
        System.out.print(min);
    }
    
    public static int countRePaint(int startRow, int startCol, char[][] board){
        int count_start_B = 0;
        int count_start_W = 0;
        
        //시작이 B - row+col 짝수(0포함) : B | row+col 홀수 : W 
        for(int i = startRow; i<startRow+8; i++){
            for(int j = startCol; j<startCol+8; j++){
                if((i+j)%2==0){
                    if(board[i][j]=='W'){
                        count_start_B++;
                    }
                }
                else{
                    if(board[i][j]=='B'){
                        count_start_B++;
                    }
                }
            }
        }
        
        //시작이 W - row+col 짝수(0포함) : W | row+col 홀수 : B
        for(int i = startRow; i<startRow+8; i++){
            for(int j = startCol; j<startCol+8; j++){
                if((i+j)%2==0){
                    if(board[i][j]=='B'){
                        count_start_W++;
                    }
                }
                else{
                    if(board[i][j]=='W'){
                        count_start_W++;
                    }
                }
            }
        }
        return Math.min(count_start_B, count_start_W);
    }
}