import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        int n = 0;
        String game = "";
        int max = 0;
        int count = 0;
        int answer = 0;
        Set<String> s = new HashSet<String>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        game = st.nextToken();
        if(game.equals("Y")) max = 1;
        else if(game.equals("F")) max = 2;
        else if(game.equals("O")) max = 3;

        for(int i = 0; i<n; i++){
            String player = br.readLine();
            if(!s.contains(player)){
                count++;
                s.add(player);
            }
            if(count >= max){
                answer++;
                count = 0;
            }
        }

        System.out.print(answer);
    }
}