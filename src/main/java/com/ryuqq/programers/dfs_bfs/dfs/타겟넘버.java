package com.ryuqq.programers.dfs_bfs.dfs;

public class 타겟넘버 {

    private static int count = 0;
    public int solution(int[] numbers, int target) {


        dfs(numbers, target, 0, 0);

        return count;
    }


    public void dfs(int[] numbers, int target,  int n, int currentSum) {

        if(n == numbers.length) {
            if(currentSum == target) {
                count++;
            }
            return;
        }

        dfs(numbers, target, n + 1, currentSum + numbers[n]);
        dfs(numbers, target, n + 1, currentSum - numbers[n]);

    }

    public static void main(String[] args) {
        타겟넘버 answer = new 타겟넘버();
        int[] numbers = {1, 1, 1, 1, 1};
        answer.solution(numbers, 3);
    }



}
