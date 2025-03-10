import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeight = 0;
        int index = 0; // truck_weights 배열의 인덱스

        // 다리 길이만큼 초기화 (빈 공간을 0으로 채움)
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length || totalWeight > 0) {
            answer++; // 매 초 증가

            // 다리에서 트럭을 하나 내림
            totalWeight -= bridge.poll();

            // 새 트럭을 다리에 올릴 수 있는지 확인
            if (index < truck_weights.length && totalWeight + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]); // 트럭 추가
                totalWeight += truck_weights[index];
                index++;
            } else {
                bridge.offer(0); // 트럭이 못 올라가면 0 추가 (빈 자리 유지)
            }
        }

        return answer;
    }
}