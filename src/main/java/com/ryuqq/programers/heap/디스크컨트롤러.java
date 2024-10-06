package com.ryuqq.programers.heap;

import java.util.*;

//30723682
public class 디스크컨트롤러 {


    public class Disc{
        private final int order;
        private final int processingTime;

        public Disc(int order, int processingTime) {
            this.order = order;
            this.processingTime = processingTime;
        }

        public int getOrder() {
            return order;
        }

        public int getProcessingTime() {
            return processingTime;
        }

    }

    public int solution(int[][] jobs) {

        PriorityQueue<Disc> pq = new PriorityQueue<>(Comparator.comparingInt(Disc::getProcessingTime));
        List<Disc> originList = new ArrayList<>();

        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        for (int[] job : jobs) {
            Disc disc = new Disc(job[0], job[1]);
            originList.add(disc);
        }



        int processingTime = 0;
        int currentTime = 0;
        int finishedCount = 0;
        int jobIndex = 0;

        while(finishedCount < originList.size()) {

            while(jobIndex < originList.size() && originList.get(jobIndex).getOrder() <= currentTime) {
                pq.add(originList.get(jobIndex));
                jobIndex++;
            }

            if(!pq.isEmpty()){
                Disc poll = pq.poll();
                processingTime +=  currentTime - poll.getOrder() + poll.getProcessingTime();
                currentTime += poll.getProcessingTime();
                finishedCount++;
            }else{
                currentTime = originList.get(jobIndex).getOrder();
            }

        }

        return processingTime / originList.size();
    }

    public static void main(String[] args) {
        디스크컨트롤러 answer = new 디스크컨트롤러();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int solution = answer.solution(jobs);
        System.out.println("solution = " + solution);

    }

}
