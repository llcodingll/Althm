class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int num=0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                num = (int)s.charAt(i);
                answer += (char)num;
            }
            else{
                if('a'<=s.charAt(i)&&'z'>=s.charAt(i)){
                    num = (int)'a' + ((int)s.charAt(i) - (int)'a' + n)%26;
                }
                if('A'<=s.charAt(i)&&'Z'>=s.charAt(i)){
                    num = (int)'A' + ((int)s.charAt(i) - (int)'A' + n)%26;
                }
                answer += (char)num;
            }         
        }
        
        return answer;
    }
}