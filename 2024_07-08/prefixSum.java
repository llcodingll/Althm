import java.util.*;

public class prefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 배열을 통해 각 점의 위치를 반영하여 값 저장
        int[] values = new int[1000001];
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int idx = sc.nextInt();
            values[idx] += value;
        }

        long maxSum = 0;
        long currentSum = 0;

        //윈도우 초기값 계산
        for (int i = 0; i <= k && i < values.length; i++) {
            currentSum += values[i];
        }
        maxSum = currentSum;

        // 슬라이딩 윈도우
        for (int i = k + 1; i < values.length; i++) {
            currentSum += values[i];
            if (i > 2 * k) {
                currentSum -= values[i - 2 * k - 1];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}