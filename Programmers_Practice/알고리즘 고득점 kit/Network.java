class Solution {
    static boolean[] visited;

    static public void DFS(int curr, int n, int[][] computers){
        visited[curr] = true;
        for(int i = 1; i<n; i++){
            if(computers[curr][i] == 1 && !visited[i]) DFS(i, n, computers);
        }
        return;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                DFS(i, n, computers);
                answer++;
            }
        }

        return answer;
    }
}