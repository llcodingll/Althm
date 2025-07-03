import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int switchNum = Integer.parseInt(br.readLine());
        boolean[] switchList = new boolean[switchNum];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<switchNum; i++){
            if(Integer.parseInt(st.nextToken()) == 1) switchList[i] = true;
        }

        int studentNum = Integer.parseInt(br.readLine());
        int[][] studentList = new int[studentNum][2];
        for(int i = 0; i<studentNum ; i++){
            st = new StringTokenizer(br.readLine());
            studentList[i][0] = Integer.parseInt(st.nextToken());
            studentList[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<studentNum; i++){
            int num = studentList[i][1];
            int mul = 1;
            if(studentList[i][0] == 1){
                while(num<=switchNum){
                    if(switchList[num - 1]) switchList[num - 1] = false;
                    else switchList[num - 1] = true;
                    mul++;
                    num = studentList[i][1] * mul;
                }
            }
            else{
                if(switchList[num - 1]) switchList[num - 1] = false;
                else switchList[num - 1] = true;
                while(num-mul-1>=0 && num+mul-1<switchNum){
                    if(switchList[num-mul-1] && switchList[num+mul-1]){
                        switchList[num-mul-1] = false;
                        switchList[num+mul-1] = false;
                    }
                    else if(!switchList[num-mul-1] && !switchList[num+mul-1]){
                        switchList[num-mul-1] = true;
                        switchList[num+mul-1] = true;
                    }
                    else break;
                    mul++;
                }
            }
        }

        for(int i = 0; i<switchNum; i++){
            if(switchList[i]) System.out.print(1+" ");
            else System.out.print(0+" ");

            if((i + 1) % 20 == 0 || i == switchNum - 1){
                System.out.println();
            }
        }
    }
}