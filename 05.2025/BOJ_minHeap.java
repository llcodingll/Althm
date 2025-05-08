import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_minHeap {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pQue.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(pQue.poll());
                }
            } else {
                pQue.add(num);
            }
        }
    }
}