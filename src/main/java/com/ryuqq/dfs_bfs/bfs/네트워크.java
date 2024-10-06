package com.ryuqq.dfs_bfs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 네트워크 {

    private static int count = 0;

    public int solution(int n, int[][] computers) {
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }

        for(int i =0; i < computers.length; i++) {
            for(int j =0; j < computers[i].length; j++) {
                if(i != j && computers[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        for(int i =0; i < n; i++) {
            if(!visited[i]){
                bfs(i, graph, visited);
                count++;
            }
        }

        return count;
    }


    private void bfs(int start, List<Integer>[] graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            for(int i : graph[poll]) {
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        네트워크 answer= new 네트워크();
        int[][] computers = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        answer.solution(3, computers);

    }



}
