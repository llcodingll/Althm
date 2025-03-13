//더 맵게
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.offer(i);
        }
        while(true){
            if(pq.peek()<K){
                if(pq.size()<2){
                    answer = -1;
                    break;
                }
                int newFood = pq.poll() + pq.poll()*2;
                pq.offer(newFood);
                answer++;
            }
            else break;
        }

        return answer;
    }
}