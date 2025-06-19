import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();

    public static void DFS(int curr, String start, String path, String[][] tickets){
        if(curr == tickets.length){
            answer.add(path);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                DFS(curr+1, tickets[i][1], path+" "+tickets[i][1], tickets);
                visited[i] = false;
            }
        }

    }

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        DFS(0, "ICN", "ICN", tickets);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
}