import java.io.*;
import java.util.*;

public class NotTriple {
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static ArrayList<Integer> count = new ArrayList<>();

    public static void print(){
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }

    public static void choose(int n, int k, int curNum){
        if(curNum == n+1){
            boolean isTriple = false;
            for(int cnt : count){
                if(cnt>=3){
                    isTriple = true;
                }
            }
            if(!isTriple){
                print();
            }
            return;
        }
        for(int i = 1; i<=k; i++){
            if(answer.size()>0 && i == answer.get(answer.size()-1)){
                count.set(count.size()-1, count.get(count.size()-1)+1);
            }
            else{
                count.add(1);
            }
            answer.add(i);
            choose(n, k, curNum+1);
            answer.remove(answer.size()-1);
            if(count.get(count.size()-1) <= 1){
                count.remove(count.size()-1);
            }
            else{
                count.set(count.size()-1, count.get(count.size()-1)-1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        count.add(1);
        choose(n, k, 1);
    }
}