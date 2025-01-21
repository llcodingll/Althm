import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 0;
        String three = Integer.toString(n,3);
        for(int i = 0 ; i<three.length() ; i++){
            num = (int)Math.pow(3,i);
            num *= three.charAt(i) - '0';
            answer += num;
        }
        
        return answer;
    }
}