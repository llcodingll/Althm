//IL 4. lesson 04 - 순열 만들기 : 거꾸로 순열
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer> number = new ArrayList<Integer>();
    static boolean[] visited;

    public static void choose(int curr){
        if(curr == n+1){
            printNumber();
            return;
        }

        for(int i = n; i>=1; i--){
            if(visited[i]) continue;
            number.add(i);
            visited[i] = true;

            choose(curr+1);

            number.remove(number.size()-1);
            visited[i] = false;
        }
        return;
    }

    public static void printNumber(){
        for(int i = 0; i<number.size(); i++){
            System.out.print(number.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        choose(1);
    }
}