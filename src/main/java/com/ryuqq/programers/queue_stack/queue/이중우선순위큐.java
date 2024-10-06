package com.ryuqq.programers.queue_stack.queue;

import java.util.*;

public class 이중우선순위큐 {


    public int[] solution(String[] operations) {
        PriorityQueue<Integer> lowestQueue = new PriorityQueue<>();
        PriorityQueue<Integer> highestQueue = new PriorityQueue<>(Comparator.reverseOrder());

        Map<Integer, Integer> syncMap = new HashMap<>();

        for(String operation : operations) {
            if(operation.startsWith("I")){
                String s = operation.split(" ")[1];
                int num = Integer.parseInt(s);
                lowestQueue.add(num);
                highestQueue.add(num);
                syncMap.put(num, syncMap.getOrDefault(num, 0) + 1);
            }

            if(operation.startsWith("D")) {
                String s = operation.split(" ")[1];
                int num = Integer.parseInt(s);

                if(num == 1){
                    Integer target = highestQueue.poll();
                    removeNum(lowestQueue, syncMap, target);
                }

                if(num == -1){
                    Integer target = lowestQueue.poll();
                    removeNum(highestQueue, syncMap, target);
                }
            }
        }



        int lowest = selectTop(highestQueue, syncMap);
        int highest = selectTop(lowestQueue, syncMap);

        return new int[]{lowest,highest};
    }

    private int selectTop(PriorityQueue<Integer> queue, Map<Integer, Integer> syncMap){
        if(queue.isEmpty()) return 0;
        else{
            for(Integer q : queue){
                if(syncMap.getOrDefault(q, 0) > 0){
                    return q;
                }
            }
        }
        return 0;
    }


    private void removeNum(PriorityQueue<Integer> queue, Map<Integer, Integer> syncMap, Integer num){
        for(Integer q : queue){
            if(syncMap.getOrDefault(q, 0) > 0){
                if(Objects.equals(q, num)){
                    syncMap.put(num, syncMap.getOrDefault(q, 0) -1);
                    queue.remove(q);
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        이중우선순위큐 answer = new 이중우선순위큐();
        int[] result = answer.solution(operations);
        System.out.println("solution = " + result);
    }


}
