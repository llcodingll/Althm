import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        Character [] str = new Character [s.length()]; 
        for(int i = 0; i<s.length(); i++){
            str[i] = s.charAt(i);
        }
        Arrays.sort(str, Collections.reverseOrder());
        for(int j = 0; j<s.length(); j++){
            answer += str[j];
        }
        return answer;
    }
}