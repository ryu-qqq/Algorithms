package com.ryuqq.pccp;

import java.util.LinkedList;
import java.util.Queue;

public class 석유시추 {

    private final int[] xArr = {1, -1, 0, 0};
    private final int[] yArr = {0, 0, -1, 1};
    private int[] fuel;
    private int answer = 0;  // 최종 최대 석유량


    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        fuel = new int[m];
        boolean[][] visited = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (land[row][col] == 1 && !visited[row][col]) {
                    bfs(land, visited, row, col);
                }
            }
        }

        return answer;
    }


    public void bfs(int[][] land, boolean[][] visited, int x, int y){
        int n = land.length;
        int m = land[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 1;
        boolean[] visitedY = new boolean[m];
        visitedY[y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {
                int newX = curX + xArr[i];
                int newY = curY + yArr[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && land[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                    count++;
                    visitedY[newY] = true;
                }
            }
        }

        for (int col = 0; col < m; col++) {
            if (visitedY[col]) {
                fuel[col] += count;
                answer = Math.max(answer, fuel[col]);
            }
        }

    }


}
