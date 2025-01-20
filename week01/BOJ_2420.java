import java.io.*;

public class BOJ_2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] strArr = br.readLine().split(" ");

        Long firstInt = Long.valueOf(strArr[0]);
        Long secondInt = Long.valueOf(strArr[1]);

        Long result = Math.abs( firstInt - secondInt);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}