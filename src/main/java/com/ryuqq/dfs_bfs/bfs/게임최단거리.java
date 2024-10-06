package com.ryuqq.dfs_bfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임최단거리 {


    public int solution(int[][] maps) {

        int width = maps.length;
        int height = maps[0].length;

        boolean[][] visited = new boolean[width][height];

        return bfs(visited, maps, 0, 0);
    }

    public int bfs(boolean[][] visited, int[][] maps, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i1 = poll[0];
            int i2 = poll[1];
            int i3 = poll[2];

            if(i1 == maps.length - 1 && i2 == maps[0].length - 1) {
                return i3;
            }

            boolean flag  = i1 < 0 || i2 < 0 || i1 >= maps.length || i2 >= maps[0].length;

            if(!flag) {
                int i = maps[i1][i2];

                if(i == 1 && !visited[i1][i2]){
                    visited[i1][i2] = true;

                    queue.add(new int[]{i1 + 1, i2, i3 + 1});
                    queue.add(new int[]{i1 - 1, i2, i3 + 1});
                    queue.add(new int[]{i1, i2 + 1, i3 + 1});
                    queue.add(new int[]{i1, i2 - 1, i3 + 1});
                }

            }
        }

        return - 1;


    }


}
