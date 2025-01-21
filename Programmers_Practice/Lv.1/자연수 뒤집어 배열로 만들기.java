class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        int tmp = 0;
        
        for(int i = 0; i<answer.length; i++){
            tmp = (int) str.charAt(i) - '0';
            answer[answer.length-1-i] = tmp;
        }
        
        return answer;
    }
}