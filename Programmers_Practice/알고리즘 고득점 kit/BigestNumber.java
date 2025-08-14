import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // int 배열을 문자열 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 커스텀 정렬: (a + b)와 (b + a) 중 더 큰 쪽이 앞에 오도록
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // 내림차순 정렬
            }
        });

        // 0이 여러 개일 경우 "000..." -> "0" 처리
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 문자열 배열을 하나로 합침
        StringBuilder answer = new StringBuilder();
        for (String num : strNumbers) {
            answer.append(num);
        }

        return answer.toString();
    }
}
