//완전탐색 : 카펫
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 3; i<brown/2; i++){
            for(int j = 3; j<brown/2; j++){
                if(brown == (i*2 + j*2 - 4) && yellow == ((i-2) * (j-2))){
                    if(i>j){
                        answer[0] = i;
                        answer[1] = j;
                    }
                    else{
                        answer[0] = j;
                        answer[1] = i;
                    }
                }
            }
        }

        return answer;
    }
}