package com.ryuqq.programers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 스코빌지수 {

    public int solution(int[] scoville, int k) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::valueOf));

        for(Integer i : scoville) {
            pq.offer(i);
        }

        while(!pq.isEmpty()){

            Integer first = pq.poll();
            if(first >= k) return answer;

            if(!pq.isEmpty()) {
                Integer second = pq.poll();
                Integer newScoville = first + (second * 2);
                pq.offer(newScoville);
                answer++;
                if(pq.peek() >=k) return answer;
            }else{
                return -1;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        스코빌지수 answer = new 스코빌지수();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int solution = answer.solution(scoville, 19000);
        System.out.println("solution = " + solution);
    }



}
