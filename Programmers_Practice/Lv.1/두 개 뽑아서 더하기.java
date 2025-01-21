import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<Integer> ();
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i = 0; i<numbers.length; i++){
            for(int j = 1; j<numbers.length-i; j++){
                if(map.get(numbers[i]+numbers[i+j])!=null){
                }
                else{
                    answer.add(numbers[i]+numbers[i+j]);
                    map.put(numbers[i]+numbers[i+j], true);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}