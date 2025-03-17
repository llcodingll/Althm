import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(String operation : operations) {
            String[] parts = operation.split(" ");
            String cmd = parts[0];
            int value = Integer.parseInt(parts[1]);

            if(cmd.equals("I")) {
                // Insert operation
                minHeap.offer(value);
                maxHeap.offer(value);
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            } else if(cmd.equals("D") && !countMap.isEmpty()) {
                // Delete operation
                if(value == 1) {
                    // Remove max
                    removeFromHeap(maxHeap, countMap);
                } else {
                    // Remove min
                    removeFromHeap(minHeap, countMap);
                }
            }
        }

        // Prepare result
        int[] answer = new int[2];

        // Get max value
        Integer max = getNextValidValue(maxHeap, countMap);
        answer[0] = (max != null) ? max : 0;

        // Get min value
        Integer min = getNextValidValue(minHeap, countMap);
        answer[1] = (min != null) ? min : 0;

        return answer;
    }

    private void removeFromHeap(PriorityQueue<Integer> heap, HashMap<Integer, Integer> countMap) {
        Integer value = getNextValidValue(heap, countMap);
        if(value != null) {
            // Decrement count
            int count = countMap.get(value);
            if(count == 1) {
                countMap.remove(value);
            } else {
                countMap.put(value, count - 1);
            }
        }
    }

    private Integer getNextValidValue(PriorityQueue<Integer> heap, HashMap<Integer, Integer> countMap) {
        Integer value = null;
        // Find the next valid value in the heap
        while(!heap.isEmpty()) {
            int candidate = heap.poll();
            if(countMap.containsKey(candidate) && countMap.get(candidate) > 0) {
                value = candidate;
                break;
            }
        }

        // Re-add the value to the heap if it's valid
        if(value != null) {
            heap.offer(value);
        }

        return value;
    }
}