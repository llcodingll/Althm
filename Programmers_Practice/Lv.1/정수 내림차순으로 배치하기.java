import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String str1 = Long.toString(n);
        String str2 = "";
        Long[] num = new Long[str1.length()];
        long answer = 0;
        
        for(int i=0; i<str1.length();i++){
            num[i] = (long) str1.charAt(i) - '0';
        }
        Arrays.sort(num,(a, b) -> Long.compare(b, a));
        
        for(int j=0; j<str1.length(); j++){
            str2 += Long.toString(num[j]);
        }
        answer = Long.valueOf(str2);
        
        return answer;
    }
}