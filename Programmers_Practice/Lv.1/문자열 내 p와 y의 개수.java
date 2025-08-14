class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_num = 0;
        int y_num = 0;
        
        for(int i =0 ; i<s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                p_num++;
            }
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                y_num++;
            }
            
        }
        
        if(p_num != y_num){
            answer = false;
        }
        
        return answer;
    }
}