//주식가격

class Solution {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[prices.length];

        for(int i = 0; i<l-1; i++){
            int count = 0;
            for(int j = i+1; j<l; j++){
                if(prices[i] > prices[j]){
                    count++;
                    break;
                }
                else count++;
            }
            answer[i] = count;
        }

        return answer;
    }
}