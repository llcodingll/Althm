//모의고사

class Solution {
    public int[] solution(int[] answers) {
        int idx = 0;
        int[] a_choice = {1, 2, 3, 4, 5};
        int[] b_choice = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c_choice = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int a_grade = 0;
        int b_grade = 0;
        int c_grade = 0;

        for(int i : answers){
            if(a_choice[idx%5] == i) a_grade++;
            if(b_choice[idx%8] == i) b_grade++;
            if(c_choice[idx%10] == i) c_grade++;
            idx++;
        }

        int max = Math.max(Math.max(a_grade, b_grade), c_grade);

        int count = 0;
        if(a_grade == max) count++;
        if(b_grade == max) count++;
        if(c_grade == max) count++;

        int[] answer = new int[count];
        int index = 0;

        if(a_grade == max) answer[index++] = 1;
        if(b_grade == max) answer[index++] = 2;
        if(c_grade == max) answer[index++] = 3;

        return answer;
    }
}