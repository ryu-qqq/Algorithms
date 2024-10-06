package com.ryuqq.array;

import java.util.Arrays;

public class 수열과구간쿼리1 {

    public int[] solution(int[] arr, int[][] queries) {

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            for(int i = start; i <= end; i++) {
                arr[i] +=1;
            }

        }

        return Arrays.copyOf(arr, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 1},{1, 2},{2, 3}};

        수열과구간쿼리1 answer = new 수열과구간쿼리1();
        int[] solution = answer.solution(arr, queries);
        System.out.println("solution = " + solution);
    }


}
