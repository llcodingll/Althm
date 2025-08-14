class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int num = 0;
        
        for(int i = left; i<=right; i++){
            for(int j = 1; j<=i; j++){
                if(i%j==0){
                    num++;
                }
            }
            if(num%2==0){
                answer+=i;
                num = 0;
            }
            else{
                answer-=i;
                num = 0;
            }
        }
        
        return answer;
    }
}