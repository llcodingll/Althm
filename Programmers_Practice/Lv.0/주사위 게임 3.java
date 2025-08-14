class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] num = {a,b,c,d};
        int same = 0;
        boolean isTriple = false;
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3-i; j++){
                if(num[j]>num[j+1]){
                    int tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
        }
        
        if(num[0] == num[1]){
            same ++;
        }
        if(num[1] == num[2]){
            if (num[0] == num[1]){
                isTriple = true;
            }
            same ++;
        }
        if(num[2] == num[3]){
            if (num[1] == num[2]){
                isTriple = true;
            }
            same ++;
        }
        
        switch(same){
            case 0:
                answer = num[0];
                break;
            case 1:
                if(num[0]==num[1]){
                    answer = num[2] * num[3];
                }
                else if(num[1]==num[2]){
                    answer = num[0] * num[3];
                }
                else{
                    answer = num[0] * num[1];
                }
                break;
            case 2:
                if(isTriple){
                    if(num[0]!=num[1]){
                        answer = (10*num[1] + num[0])*(10*num[1] + num[0]);
                    }
                    else{
                        answer = (10*num[0] + num[3])*(10*num[0] + num[3]);
                    }
                }
                else{
                    answer = (num[3]+num[0])*(num[3]-num[0]);
                }
                break;
            case 3:
                answer = 1111 * num[0];
                break;
        }
        
        return answer;
    }
}