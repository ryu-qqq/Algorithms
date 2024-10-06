package com.ryuqq.graph;

import java.util.*;

public class 가장먼노드 {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int[] edge1 : edge) {
            graph.putIfAbsent(edge1[0], new HashSet<>());
            graph.putIfAbsent(edge1[1], new HashSet<>());
            graph.get(edge1[0]).add(edge1[1]);
            graph.get(edge1[1]).add(edge1[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] distArr = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;


        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            Set<Integer> integers = graph.get(poll);

            for(Integer i : integers) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    distArr[i] = distArr[poll] + 1;
                }
            }
        }

        int max = Arrays.stream(distArr).max().getAsInt();

        for(Integer i : distArr) {
            if(Objects.equals(i, max)) answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        가장먼노드 answer = new 가장먼노드();
        int[][] arr = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int solution = answer.solution(6, arr);
        System.out.println("solution = " + solution);
    }

}
