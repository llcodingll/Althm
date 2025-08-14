import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayList<Integer> num = new ArrayList<Integer>();
        String num_str = "";
        HashMap<String, Integer> numberMap = new HashMap<>();
        
        numberMap.put("zero",0);
        numberMap.put("one",1);
        numberMap.put("two",2);
        numberMap.put("three",3);
        numberMap.put("four",4);
        numberMap.put("five",5);
        numberMap.put("six",6);
        numberMap.put("seven",7);
        numberMap.put("eight",8);
        numberMap.put("nine",9);
        
        for(int i = 0 ; i<s.length(); i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                num.add((int)s.charAt(i)-'0');
            }
            else{
                num_str += Character.toString(s.charAt(i));
                if(numberMap.get(num_str)!=null){
                    num.add(numberMap.get(num_str));
                    num_str = "";
                }
            }   
        }
        for(int j = 0; j<num.size();j++){
            answer += num.get(j) * Math.pow(10,num.size()-j-1);
        }
        
        
        return answer;
    }
}