import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Comparator<String> customComparator = (s1, s2) ->{
            if(s1.charAt(n)==s2.charAt(n)){
                return s1.compareTo(s2);
            }
            else{
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
        };
        
        Arrays.sort(strings, customComparator);
        
        String[] answer = Arrays.copyOf(strings, strings.length);
        
        return answer;
    }
}