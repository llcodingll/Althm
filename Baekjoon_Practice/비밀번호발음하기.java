import java.io.*;
import java.util.*;

class Main{
    static ArrayList<String> vowels = new ArrayList<>();

    public static boolean containsVowel(String[] list){
        for(String s : list){
            if(vowels.contains(s)) return true;
        }
        return false;
    }

    public static boolean isValid(String[] list){
        int vowelCount = 0;
        int consCount = 0;
        for(int i = 0; i<list.length; i++){
            // 같은 글자 2개 연속 체크 (ee, oo 제외)
            if(i>0 && list[i-1].equals(list[i])){
                if(!list[i-1].equals("e") && !list[i-1].equals("o")) return false;
            }

            // 자음 or 모음 3개 연속 체크
            if(vowels.contains(list[i])){
                vowelCount++;
                consCount = 0;
            }
            else{
                vowelCount = 0;
                consCount++;
            }

            if(vowelCount>=3 || consCount>=3) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        while(true){
            String input = br.readLine();
            if(input.equals("end")) break;
            String[] password = input.split("");
            if(containsVowel(password) && isValid(password)) System.out.println("<"+input+"> is acceptable.");
            else System.out.println("<"+input+"> is not acceptable.");
        }
    }
}