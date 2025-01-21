import java.util.ArrayList;
import java.lang.Integer;

class Solution {
    public ArrayList<Integer> solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int i = l ; i<=r ; i++){
            String str = Integer.toString(i);
            int valid = 0;
            for(int j = 0; j<str.length();j++){
                if(str.charAt(j)=='0' || str.charAt(j)=='5'){
                    valid ++;
                }
            }
            if(valid == str.length()){
                answer.add(i);
            } 
        }
        
        if(answer.size() == 0){
            answer.add(-1);
        }
        
        return answer;
    }
}