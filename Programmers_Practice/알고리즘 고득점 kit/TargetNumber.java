class Solution {
    static int ans = 0;
    static int n = 0;
    static public void findCase(int idx, int curr, int target, int[] numbers){
        if(idx == n){
            if(curr == target) ans++;
            return;
        }

        curr = curr - numbers[idx];
        findCase(idx+1, curr, target, numbers);
        curr = curr + numbers[idx];

        curr = curr + numbers[idx];
        findCase(idx+1, curr, target, numbers);
        curr = curr - numbers[idx];

        return;
    }

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        findCase(0, 0, target, numbers);

        return ans;
    }
}