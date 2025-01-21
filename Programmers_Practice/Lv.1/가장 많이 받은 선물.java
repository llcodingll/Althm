class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int giftScore[] = new int[friends.length]; 
        int give_take[][] = new int[friends.length][friends.length];
        int realgift[] = new int[friends.length];
        int max = 0;
        for(int i = 0 ; i < gifts.length ; i++){
            String tmp = gifts[i];
            String check[] = tmp.split(" ");
            int give = 0;
            int take = 0;
            for(int j = 0; j < friends.length ; j++){
                if (check[0].equals(friends[j])){
                    give = j;
                    giftScore[j]++;
                }
                if (check[1].equals(friends[j])){
                    take = j;
                    giftScore[j]--;
                }
            }
            give_take[give][take]++;
        }
        for(int m = 0 ; m < friends.length ; m++){
            for(int n = 0 ; n < friends.length ; n++){
                if(m!=n){
                    if(give_take[m][n]>give_take[n][m]){
                        realgift[m] ++;
                    }
                    else if(give_take[m][n]==give_take[n][m]){
                        if(giftScore[m]>giftScore[n]){
                            realgift[m] ++;
                        }
                        if(giftScore[m]<giftScore[n]){
                            realgift[n] ++;
                        }
                    }
                    else{
                        realgift[n] ++;
                    }
                }
                
            }
        }
        for(int k = 0 ; k < realgift.length ; k++){
            if(realgift[k]>max){
                max = realgift[k];
            }
        }
        answer = max/2;
        return answer;
    }
}

