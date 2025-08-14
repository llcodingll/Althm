// K 버블정렬

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int[] arr;

    public static void KBubbleSort(){
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j =0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
            count++;
            if(count == k) break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        KBubbleSort();

        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }
}