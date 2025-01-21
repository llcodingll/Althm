import java.io.*;
import java.util.*;

class Number{
    int num;
    int count;

    public Number(int num, int count){
        this.num = num;
        this.count = count;
    }
}

public class fourCalculation {
    static int[] cal1 = {1,1,2,3};
    static int[] cal2 = {-1,1,0,0};

    static int n;
    static Queue<Number> queue = new LinkedList<>();
    static int answer = -1;

    public static void bfs(){
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            Number curr = queue.poll();
            int currNum = curr.num;
            int currCount = curr.count;

            if(currNum == 1){
                answer = 0;
                return;
            }

            if (visited.contains(currNum)) continue;
            visited.add(currNum);

            for(int i=0; i<4; i++){
                if(currNum%cal1[i]==0){
                    int nextNum = currNum/cal1[i] + cal2[i];
                    int nextCount = currCount+1;
                    if(nextNum==1){
                        if(answer<0 || answer>nextCount) answer = nextCount;
                    }
                    else if(nextNum>1 && nextNum<=2*n-1) queue.add(new Number(nextNum, nextCount));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        queue.add(new Number(n, 0));
        bfs();

        System.out.println(answer);
    }
}