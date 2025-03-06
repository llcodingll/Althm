import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for(String p : participant){
            if(hm.containsKey(p)) hm.put(p, hm.get(p)+1);
            else hm.put(p, 1);
        }

        for(String c: completion){
            hm.put(c, hm.get(c)-1);
        }

        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}