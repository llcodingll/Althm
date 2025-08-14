import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map <Character,Integer> map = new LinkedHashMap<> () ;
        for(int i = 0; i<s.length(); i++){
            if(map.get(s.charAt(i))!=null){
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
            else{
                answer[i] = -1;
                map.put(s.charAt(i), i);
            }
        }
        
        return answer;
    }
}