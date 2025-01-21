import java.io.*;
import java.util.*;

public class beautyNum {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int count = 0;

    public static boolean isBeautyNum(){
        int curNum = 0;
        int curCount = 1;

        for(int i = 0; i<arr.size(); i++){
            curNum = arr.get(i);
            if(curNum == curCount){
                curCount = 1;
            }
            else{
                if(i<arr.size()-1 && curNum == arr.get(i+1)){
                    curCount++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void choose(int n, int curNum){
        if(curNum == n+1){
            if(isBeautyNum()){
                count++;
            }
            return;
        }

        for(int i = 1; i<=4; i++){
            arr.add(i);
            choose(n, curNum+1);
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        choose(n, 1);

        System.out.print(count);
    }
}