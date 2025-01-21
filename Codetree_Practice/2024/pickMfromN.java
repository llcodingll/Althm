import java.io.*;
import java.util.*;

public class pickMfromN {
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void print(){
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }
    public static void choose(int n, int m, int curNum){
        if(answer.size() == m){
            print();
            return;
        }

        for(int i = curNum; i<=n; i++){
            answer.add(i);
            choose(n, m, i+1);
            answer.remove(answer.size()-1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        choose(n, m, 1);
    }
}