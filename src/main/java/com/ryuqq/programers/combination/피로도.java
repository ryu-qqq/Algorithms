package com.ryuqq.programers.combination;

public class 피로도 {

    private int maxDungeons = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, visited);
        return maxDungeons;
    }

    public void dfs(int k , int depth, int[][] dungeons, boolean[] visited) {

        maxDungeons = Math.max(maxDungeons, depth);


        for(int i = 0 ; i < dungeons.length ; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], depth + 1, dungeons , visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        피로도 answer = new 피로도();
        int[][] dungeons = new int[][]{{80,20},{50,40},{30,10}};
        int solution = answer.solution(80, dungeons);
        System.out.println("solution = " + solution);
    }

}
