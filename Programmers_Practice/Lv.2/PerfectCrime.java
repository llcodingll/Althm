class Solution {
    static int n;
    static int m;
    static int answer;
    static boolean[][][] visited;

    static int A_Sum;
    static int B_Sum;

    public static void check(int curr, int A_Sum, int B_Sum, int[][] info){
        if(A_Sum >= n) return;

        if(B_Sum >= m) return;

        if(curr == info.length){
            answer = Math.min(answer, A_Sum);
            return;
        }

        if(visited[curr][A_Sum][B_Sum]) return;

        visited[curr][A_Sum][B_Sum] = true;
        check(curr+1, A_Sum+info[curr][0], B_Sum, info);
        check(curr+1, A_Sum, B_Sum+info[curr][1], info);
    }

    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        answer = Integer.MAX_VALUE;

        int maxSum = 0;
        for(int[] arr : info) maxSum += Math.max(arr[0], arr[1]);

        visited = new boolean[info.length+1][maxSum+1][maxSum+1];

        check(0, 0, 0, info);

        if(answer == Integer.MAX_VALUE) answer = -1;

        return answer;
    }
}