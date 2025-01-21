import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int min = arr[0];
        int min_idx = 0;
        for(int i = 0; i<arr.length; i++){
            if(min>arr[i]){
                min = arr[i];
                min_idx = i;
            }
        }
        for(int j = 0; j<arr.length; j++){
            if(j==min_idx){
            }
            else{
                answer.add(arr[j]);
            }
        }
        
        if(answer.size() == 0){
            answer.add(-1);
        }
        
        
        return answer;
    }
}