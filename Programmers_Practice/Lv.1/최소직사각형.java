class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_w = 0;
        int max_h = 0;
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if(sizes[i][0]>max_w){
                max_w = sizes[i][0];
            }
            if(sizes[i][1]>max_h){
                max_h = sizes[i][1];
            }
        }
        System.out.println(max_w + ", " + max_h);
        answer = max_w * max_h;
        return answer;
    }
}