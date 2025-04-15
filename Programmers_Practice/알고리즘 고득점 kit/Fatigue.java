import java.util.*;

class Solution {
    static ArrayList<Integer> order = new ArrayList<>();
    static int length;
    static boolean[] visited;
    static int maxNum = -1;

    public static void choose(int curr, int k, int[][] dungeons){
        if(curr == length+1){
            calculate(order, k, dungeons);
            return;
        }
        for(int i = 0; i<length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            order.add(i);

            choose(curr+1, k, dungeons);

            order.remove(order.size()-1);
            visited[i] = false;
        }
        return;
    }

    public static void calculate(ArrayList<Integer> order, int k, int[][] dungeons){
        int hp = k;
        int count = 0;
        for(int i = 0; i<order.size(); i++){
            if(hp>=dungeons[order.get(i)][0]){
                count ++;
                hp -= dungeons[order.get(i)][1];
            }
        }
        maxNum = Math.max(maxNum, count);
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        length = dungeons.length;
        visited = new boolean[length];

        choose(1, k, dungeons);
        answer = maxNum;

        return answer;
    }
}