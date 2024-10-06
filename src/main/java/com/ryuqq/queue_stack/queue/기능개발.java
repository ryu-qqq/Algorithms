package com.ryuqq.queue_stack.queue;

import java.util.*;

/**
 * 순서대로 큐에 넣는다.
 *
 */



public class 기능개발 {

    public class Function{
        private int progress;
        private int speed;
        private int day;
        private boolean finished;


        public Function(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
            this.finished = false;
            this.day = 0;
        }

        public void work(){
            while(!finished){
                this.progress = this.progress + this.speed;
                this.day ++;

                if(isFinished()){
                    this.finished = true;
                }
            }
        }

        public boolean isFinished(){
            return this.progress >=100;
        }


        public int getDay(){
            return this.day;
        }

    }


    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        List<Function> pendingList = new ArrayList<>();

        for(int i =0; i< progresses.length; i++){
            pendingList.add(new Function(progresses[i], speeds[i]));
        }

        pendingList.forEach(Function::work);
        Queue<Function> finishedList = new LinkedList<>(pendingList);

        Function firstWork = finishedList.poll();
        int count = 1;

        while(!finishedList.isEmpty()){
            Function nextWork = finishedList.poll();

            if(firstWork.getDay() >= nextWork.getDay()){
                count++;
            }else{
                answer.add(count);
                count=1;
                firstWork = nextWork;
            }

            if(finishedList.isEmpty()) answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        기능개발 answer = new 기능개발();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] solution = answer.solution(progresses, speeds);
        System.out.println("solution = " + solution);
    }

}
