import java.util.*;
import java.io.*;

class Human{
    int w;
    int h;
    int rank;

    public Human(int w, int h){
        this.w = w;
        this.h = h;
        this.rank = 0;
    }
}

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Human[] list = new Human[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list[i] = new Human(w, h);
        }

        for(int i = 0; i<n; i++){
            int biggerCount = 0;
            for(int j = 0; j<n; j++){
                if(j != i && isBigger(list[j], list[i])) biggerCount++;
            }
            list[i].rank = biggerCount+1;
        }

        for(int i = 0; i<n; i++){
            System.out.print(list[i].rank+" ");
        }
    }

    public static boolean isBigger(Human a, Human b){
        return (a.w > b.w && a.h > b.h);
    }
}