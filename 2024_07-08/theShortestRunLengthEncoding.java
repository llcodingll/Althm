import java.util.*;

public class theShortestRunLengthEncoding {
    public static void main(String[] args) {
        /* 입력 받기 */
        Scanner sc = new Scanner(System.in);
        String[] st = sc.next().split("");
        int len = st.length;
        
        /* 맨 앞자리 문자와 맨 뒷자리 문자가 같은 경우 : shift 진행 */
        if(st[0].equals(st[len-1])){
            int endCount = 1;
            for(int i = len-1; i>0; i--){
                if(st[i].equals(st[i-1])){
                    endCount++;
                }
                else{
                    break;
                }
            }

            //endcount만큼 shift 진행
            for(int i = 0; i<endCount; i++){
                String tmp = st[len-1];
                for(int j = len-1; j>0; j--){
                    st[j] = st[j-1];
                }
                st[0] = tmp;
            }
        }

        /* Run-Length Encoding 진행 */
        String result = "";
        int count = 1;
        for(int i = 0; i<len; i++){
            if(i<len-1&&st[i].equals(st[i+1])){
                count++;
            }
            else{
                result += st[i] + count + "";
                count=1;
            }
        }

        System.out.print(result.length());
    }
}