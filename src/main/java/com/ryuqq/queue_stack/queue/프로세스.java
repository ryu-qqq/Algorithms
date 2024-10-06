package com.ryuqq.queue_stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {

    public class Process{
        private int priority;
        private int order;

        public Process(int priority, int order) {
            this.priority = priority;
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public int getOrder(){
            return order;
        }

    }


    public int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<Process> queues = new LinkedList<>();

        int idx = 0;


        for(Integer i : priorities){
            queues.add(new Process(i, idx++));
        }

        while(!queues.isEmpty()){
            Process process = queues.poll();

            boolean highestPriority = true;
            boolean isCount = false;

            for(Process p : queues){

                if(process.getPriority() < p.getPriority()){
                    queues.add(process);
                    highestPriority = false;
                    break;
                }

            }

            if(highestPriority){
                isCount = true;
                if(process.getOrder() == location) return answer;
            }

            if(isCount) answer++;

        }

        return answer;
    }




    public static void main(String[] args) {
        프로세스 answer = new 프로세스();
        int[] priorities ={1, 1, 9, 1, 1, 1};

        int solution = answer.solution(priorities, 0);
    }



}
