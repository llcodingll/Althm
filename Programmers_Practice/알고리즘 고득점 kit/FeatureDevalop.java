import java.util.*;

class Feature{
    int progress;
    int speed;

    public Feature(int progress, int speed){
        this.progress = progress;
        this.speed = speed;
    }

    public void increaseProgress(){
        this.progress += speed;
    }
}

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Feature> st = new Stack<>();
        int l = progresses.length;
        int count = 0;

        for(int i = l-1; i>=0; i--){
            st.push(new Feature(progresses[i], speeds[i]));
        }

        while(!st.empty()){
            int size = st.size();
            for(int i = size-1; i>=0; i--){
                Feature ft = st.get(i);
                ft.increaseProgress();

                st.set(i, ft);
            }
            while(!st.empty() && st.peek().progress >= 100){
                st.pop();
                count++;
            }
            if(count!=0){
                answer.add(count);
                count = 0;
            }
        }

        return answer;
    }
}