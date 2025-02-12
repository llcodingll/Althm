import java.util.Scanner;

public class Palindrome1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            
            int N = sc.nextInt(); //찾고자하는 회문의 길이

            char[][] arr = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String tmp = sc.next();
                for (int j = 0; j < tmp.length(); j++) {
                    arr[i][j] = tmp.charAt(j);
                }
            }
 
            //회문 총 카운트
            int cnt = 0;
            //가로 검사(행 우선 순회)
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length-N+1; j++) {
                    boolean find = true;
                    for (int k = 0; k < N/2; k++) {
                        if(arr[i][k+j] != arr[i][N-k-1+j]){
                            find = false;
                            break;
                        }
                    }
                    if(find){
                        cnt++;
                    }
                }
            }

            //세로 검사
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length-N+1; j++) {
                    boolean find = true;
                    for (int k = 0; k < N/2; k++) {
                        if(arr[k+j][i] != arr[N-k-1+j][i]){
                            find = false;
                            break;
                        }
                    }
                    if(find){
                        cnt++;
                    }
                }
            }
            System.out.println("#"+tc+" "+cnt);
        }
    }
}
