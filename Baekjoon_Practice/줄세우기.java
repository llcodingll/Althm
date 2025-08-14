import java.io.*;
import java.util.*;

class Main{
    public static int sort(int[] list, int answer){
        for(int i = 0; i<20; i++){
            for(int j = i-1; j>=0; j--){
                if(list[j+1]<list[j]){
                    int tmp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = tmp;
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int[] list = new int[20];

        for(int i = 0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int answer = 0;
            for(int j = 0; j<20; j++) list[j] = Integer.parseInt(st.nextToken());
            answer = sort(list, answer);
            System.out.print(num+" "+answer);
            System.out.println();
        }
    }
}