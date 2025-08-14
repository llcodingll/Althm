import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        str += Integer.toString(n);
        
        for(int i = 0; i<str.length(); i++){
            System.out.println(Integer.valueOf(str));
            answer += Integer.valueOf(str.charAt(i)-'0');
        }
        
        
        return answer;
    }
}