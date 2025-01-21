class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int [2];
        
        for(int i = 1; i<=m*n;i++){
            if(m%i == 0 && n%i == 0){
                answer[0] = i;
            }
        }
        for(int j = m*n;j>=1;j--){
            if(j%m==0 && j%n==0){
                answer[1] = j;
            }
        }
        
        return answer;
    }
}