package com.ryuqq.dfs_bfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {


    private static int[] xPath = {-1, 1, 0, 0};
    private static int[] yPath = {0, 0, -1, 1};
    private static boolean[][] map = new boolean[101][101];
    private static boolean[][] tempMap = new boolean[101][101];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        getPath(rectangle);
        return bfs(characterX * 2 , characterY * 2, itemX * 2, itemY * 2);
    }

    private void getPath(int[][] rectangle){
        for(int[] rect : rectangle){
            fillMap(rect);
        }
    }

    private void fillMap(int[] rect) {
        int x1 = rect[0]* 2;
        int y1 = rect[1]* 2;
        int x2 = rect[2]* 2;
        int y2 = rect[3]* 2;

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                boolean b = i == x1 || i == x2 || j == y1 || j == y2;
                if(!b){
                    tempMap[i][j] = true;
                }
            }
        }

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if(i == x1 || i == x2 || j == y1 || j == y2 ){
                    if(!tempMap[i][j]){
                        map[i][j] = true;
                    }
                }else{
                    map[i][j] = false;
                }
            }
        }
    }


    private int bfs(int x, int y, int itemX, int itemY){
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int xPos = position[0];
            int yPos = position[1];
            int dist = position[2];


            if(xPos == itemX && yPos == itemY){
                return dist / 2;
            }

            if(map[xPos][yPos]){
                for(int i =0; i<4; i++){
                    int nx = xPos + xPath[i];
                    int ny = yPos + yPath[i];
                    if(nx >= 0 && ny >= 0 && nx < 101 && ny < 101 && map[nx][ny] && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        아이템줍기 answer = new 아이템줍기();

        int[][] rectangle = new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int solution = answer.solution(rectangle, 1, 3, 7, 8);
        System.out.println("solution = " + solution);
    }




}
