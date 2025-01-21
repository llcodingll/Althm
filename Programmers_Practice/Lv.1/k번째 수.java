import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int m = 0; m<commands.length; m++){
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];
            
            int[] splitArray = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(splitArray);
            answer[m] = splitArray[k-1];
        }
        
        return answer;
    }
}