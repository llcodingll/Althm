class Solution {
    public String solution(String s) {
        String answer = "";
        String ch = "";
        boolean even = true;
        
        for(int i = 0; i<s.length();i++){
            ch += s.charAt(i);
            if(ch.equals(" ")){
                even = true;
                answer += ch;
                ch = "";
            }
            else{
                if(even){
                    answer += ch.toUpperCase();
                    ch = "";
                    even = false;
                }
                else{
                    answer += ch.toLowerCase();
                    ch = "";
                    even = true;
                }
                    
            }
            
        }
        
        return answer;
    }
}