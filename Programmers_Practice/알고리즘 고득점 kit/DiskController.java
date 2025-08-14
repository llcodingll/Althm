import java.util.*;

class Job implements Comparable<Job> {
    int num;
    int requestTime;
    int durationTime;

    public Job(int n, int r, int d) {
        this.num = n;
        this.requestTime = r;
        this.durationTime = d;
    }

    @Override
    public int compareTo(Job j) {
        if (this.durationTime == j.durationTime) {
            if(this.requestTime == j.requestTime) return this.num - j.num;
            return this.requestTime - j.requestTime; // 수정: 요청 시간으로 비교
        }
        return this.durationTime - j.durationTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int len = jobs.length;
        int answer = 0;
        int time = 0;

        // 요청 시간 기준으로 정렬하기 위한 배열 생성
        Job[] jobArray = new Job[len];
        for(int i = 0; i < len; i++) {
            jobArray[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(jobArray, Comparator.comparingInt(job -> job.requestTime));

        PriorityQueue<Job> waitingQueue = new PriorityQueue<>(); // 소요시간이 짧은 순으로 정렬

        int jobIndex = 0; // 다음에 처리할 작업의 인덱스
        int completedJobs = 0; // 완료된 작업 수

        while(completedJobs < len) {
            // 현재 시간에 요청된 작업들을 대기 큐에 추가
            while(jobIndex < len && jobArray[jobIndex].requestTime <= time) {
                waitingQueue.offer(jobArray[jobIndex]);
                jobIndex++;
            }

            if(waitingQueue.isEmpty()) {
                // 대기 큐가 비어있으면 다음 작업의 요청 시간으로 이동
                time = jobArray[jobIndex].requestTime;
            } else {
                // 소요시간이 가장 짧은 작업 처리
                Job currentJob = waitingQueue.poll();
                answer += time + currentJob.durationTime - currentJob.requestTime;
                time += currentJob.durationTime;
                completedJobs++;
            }
        }

        return answer / len;
    }
}