import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int i = 0; i<n; i++){
            if(hm.get(nums[i]) != null) hm.put(nums[i], hm.get(nums[i])+1);
            else hm.put(nums[i], 1);
        }

        if(hm.size()>(n/2)) answer = n/2;
        else answer = hm.size();

        return answer;
    }
}