import java.io.*;
import java.util.*;

public class recursion {
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static void print(){
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }
    public static void choose(int n, int k, int curNum){
        if(curNum == n+1){
            print();
            return;
        }

        for(int i = 1; i<=k; i++){
            answer.add(i);
            choose(n, k, curNum+1);
            answer.remove(answer.size()-1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        choose(n, k, 1);
    }
}