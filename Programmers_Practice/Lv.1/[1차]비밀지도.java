import java.util.*;
import java.lang.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] str1 = new String[n];
        String[] str2 = new String[n];
        for(int i = 0; i<n ; i++){
            str1[i] = String.format("%0"+n+"d",Long.parseLong(Long.toBinaryString(arr1[i])));
            str2[i] = String.format("%0"+n+"d",Long.parseLong(Long.toBinaryString(arr2[i])));
            answer[i] = "";
            System.out.println(str1[i]+" "+str2[i]);
            for(int j = 0; j<n; j++){
                if(str1[i].charAt(j)=='0'&&str2[i].charAt(j)=='0'){
                    answer[i] += " ";
                }
                else{
                    answer[i] += "#";
                }
            }
            
            
            
        }
        
        
        return answer;
    }
}