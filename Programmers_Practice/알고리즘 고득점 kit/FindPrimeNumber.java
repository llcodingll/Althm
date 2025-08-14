import java.util.*;

class Solution {
    static public void permute(String current, String[] digits, boolean[] visited, Set<Integer> primes){
        if(!current.isEmpty()){
            int num = Integer.parseInt(current);
            if(isPrime(num)) primes.add(num);
        }
        for(int i = 0; i<digits.length; i++){
            if(!visited[i]){
                visited[i] = true;
                permute(current+digits[i], digits, visited, primes);
                visited[i] = false;
            }
        }
    }

    static public boolean isPrime(int num){
        if(num<2) return false;
        for(int i = 2; i<num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public int solution(String numbers) {
        int answer = 0;
        String[] digits = numbers.split("");
        boolean[] visited = new boolean[digits.length];
        Set<Integer> primes = new HashSet<>();

        permute("", digits, visited, primes);
        answer = primes.size();

        return answer;
    }
}