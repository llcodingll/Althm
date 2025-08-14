// 스택/큐 : 프로세스
import java.util.*;

class Process {
    int priority;
    int location;

    public Process(int priority, int location){
        this.priority = priority;
        this.location = location;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }

        while(!queue.isEmpty()){
            Process currProcess = queue.poll();
            Iterator<Process> iterator = queue.iterator();
            boolean isRun = true;
            for(int i = 0; i<queue.size(); i++){
                Process tmpProcess = iterator.next();
                if(tmpProcess.priority>currProcess.priority){
                    queue.offer(currProcess);
                    isRun = false;
                    break;
                }
            }
            if(isRun){
                answer += 1;
                if(currProcess.location == location) break;
            }
        }

        return answer;
    }
}