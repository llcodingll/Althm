
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MonotoneIncreasingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            ArrayList<Integer> multiply = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    multiply.add(nums[i] * nums[j]);
                }
            }

            int curr = 0;
            int max = -1;

            for (int i = 0; i < multiply.size(); i++) {
                curr = multiply.get(i);
                int tmp = curr;
                LinkedList<Integer> que = new LinkedList<>();
                while (tmp >= 10) {
                    int share = tmp / 10;
                    int remain = tmp % 10;

                    que.addFirst(remain);
                    tmp = share;

                    if (tmp < 10) {
                        que.addFirst(tmp);
                        break;
                    }
                }

                boolean isMonotoneIncreasing = true;
                for (int j = 0; j < que.size() - 1; j++) {
                    if (que.get(j) > que.get(j + 1)) {
                        isMonotoneIncreasing = false;
                        break;
                    }
                }

                if (isMonotoneIncreasing) {
                    if (curr > max) {
                        max = curr;
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
