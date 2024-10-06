package com.ryuqq.dfs_bfs.dfs;

import java.util.*;

public class 여행경로 {


    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        boolean[] visited = new boolean[tickets.length];
        result.add("ICN");

        dfs("ICN", result, 0, tickets, visited);

        return result.toArray(String[]::new);
    }


    private boolean dfs(String start, List<String> result, int depth, String[][] tickets, boolean[] visited){
        if(depth == tickets.length){
            return true;
        }


        for(int i = 0; i < tickets.length; i++){

            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                result.add(tickets[i][1]);
                if(dfs( tickets[i][1], result, depth + 1, tickets, visited)){
                    return true;
                }
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }


        return false;
    }




    public static void main(String[] args) {
        String[][] tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        여행경로 answer =new 여행경로();
        answer.solution(tickets);
    }

}



