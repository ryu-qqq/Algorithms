package com.ryuqq.combination;

import java.util.ArrayList;
import java.util.List;

public class 송전탑 {

    public int solution(int n, int[][] wires) {
        int minCount = Integer.MAX_VALUE;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] w : wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }

        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];

            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            boolean[] visited = new boolean[n + 1];
            int count = dfs(v1, graph, visited);

            int difference = Math.abs(count - (n - count));

            minCount = Math.min(minCount, difference);

            graph[v1].add(v2);
            graph[v2].add(v1);

        }

        return minCount;
    }


    private int dfs(int node, List<Integer> [] graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for(Integer i : graph[node]){
            if(!visited[i]){
                count += dfs(i, graph, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        송전탑 answer = new 송전탑();
        int[][] wires = new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int solution = answer.solution(9, wires);
        System.out.println("solution = " + solution);

    }



}
