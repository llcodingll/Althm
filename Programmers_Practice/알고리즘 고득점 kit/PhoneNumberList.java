import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phone = new HashSet<>();

        for(String num : phone_book){
            phone.add(num);
        }

        StringBuilder sb = new StringBuilder();
        for(String num : phone_book){
            char[] arr = num.toCharArray();
            for(int i = 0; i<arr.length-1; i++){
                sb.append(arr[i]);
                if(phone.contains(sb.toString())) return false;
            }
            sb.setLength(0);
        }

        return true;
    }
}