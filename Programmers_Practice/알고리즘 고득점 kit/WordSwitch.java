class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static String targetWord;

    static public void DFS(String word, int curr, String[] words){
        if(word.equals(targetWord)){
            answer = Math.min(answer, curr);
            return;
        }
        for(int i = 0; i<words.length; i++){
            if(CanSwitch(word, words[i]) && !visited[i]){
                visited[i] = true;
                DFS(words[i], curr+1, words);
                visited[i] = false;
            }
        }
    }

    static public boolean CanSwitch(String a, String b){
        int diffCount = 0;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diffCount++;
        }
        if(diffCount == 1) return true;
        else return false;
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        targetWord = target;

        DFS(begin, 0, words);
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }
}