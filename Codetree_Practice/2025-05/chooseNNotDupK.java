import java.io.*;
import java.util.*;

public class Main {
    static int n = 0;
    static int k = 0;
    static ArrayList<Integer> number = new ArrayList<>();

    public static void choose(int curr){
        if(curr == n+1){
            printNumber();
            return;
        }
        for(int i = 1; i<=k; i++){
            if(number.size()>=2 && number.get(number.size()-1)==i && number.get(number.size()-2)==i) continue;

            number.add(i);
            choose(curr+1);
            number.remove(number.size()-1);
        }
        return;
    }

    public static void printNumber(){
        for(int i = 0; i<number.size();i++){
            System.out.print(number.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose(1);
    }
}