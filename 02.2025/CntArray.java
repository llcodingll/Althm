
import java.util.Arrays;

public class CntArray {

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 4, 3, 3, 2, 2, 1, 1};
        int K = 0;
        for (int i = 0; i < arr.length; i++) {
            K = Arrays.stream(arr).max().getAsInt();
        }

        int[] cnt = new int[K + 1];

        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--cnt[arr[i]]] = arr[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
