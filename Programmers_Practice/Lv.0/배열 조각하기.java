import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int[] query) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int position = 0;
        
        for(int i = 0 ; i<query.length;i++){
            ArrayList<Integer> split = new ArrayList<Integer>();
            position = query[i];
            if(i==0){
                for(int j = 0; j <= position; j++){
                    split.add(arr[j]);
                }
            }
            else{
                if(i%2==0){
                    for(int k = 0; k <= position; k++){
                        split.add(answer.get(k));
                    }
                }
                else{
                    for(int l = position; l <= answer.size()-1; l++){
                        split.add(answer.get(l));
                    }
                }
            }
            answer = split;
        }
        
        return answer;
    }
}