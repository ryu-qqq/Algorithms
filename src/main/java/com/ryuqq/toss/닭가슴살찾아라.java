package com.ryuqq.toss;

//7 이 닭가슴살
//0은 액상과당 피애햐함, 8 초콜릿 도 피해야함


//출발지점은 무조건 왼쪽 오른쪾
//이후에은 위아래

//반복
//
public class 닭가슴살찾아라 {

    private static boolean[][] visited;
    private int rows;
    private int cols;

    public boolean solution(int[][] arr, int[] start){

        int xPos = start[0];
        int yPos = start[1];

        rows = arr.length;
        cols = arr[0].length;

        if(xPos <0 || yPos <0 || xPos >= rows || yPos >= cols){
            return false;
        }

        if(arr[xPos][yPos] == 7){
            return true;
        }

        visited = new boolean[rows][cols];
        return dfs(arr, xPos, yPos, false);
    }

    public boolean dfs(int[][] arr, int x, int y, boolean flag){
        if(x <0 || y <0 || x >= rows || y >= cols){
            return false;
        }

        if(arr[x][y] == 7){
            return true;
        }

        visited[x][y] = true;

        int moving = arr[x][y];

        if(flag){
            return dfs(arr, x, y + moving, false);
        }else{
            return dfs(arr, x + moving, y + moving, true);
        }




    }
}
