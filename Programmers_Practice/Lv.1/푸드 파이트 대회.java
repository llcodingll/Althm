import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        int sum = 0;
        for(int i = 1 ; i<food.length; i++){
            food[i] = food[i]/2;
        }
        for(int j = 1 ; j<food.length; j++){
            for(int k = 0; k<food[j]; k++){
                answer += Integer.toString(j);
            }
        }
        answer += "0";
        for(int m = food.length-1 ; m>0; m--){
            for(int n = 0; n<food[m]; n++){
                answer += Integer.toString(m);
            }
        }
        return answer;
    }
}