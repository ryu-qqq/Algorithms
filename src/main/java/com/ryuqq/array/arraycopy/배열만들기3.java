package com.ryuqq.array.arraycopy;

public class 배열만들기3 {

    public int[] solution(int[] arr, int[][] intervals) {
        int length = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            length += end - start + 1;
        }
        int[] answer = new int[length];

        int temp = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            System.arraycopy(arr, start, answer, temp, end - start + 1);
            temp = end - start + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        배열만들기3 answer = new 배열만들기3();

        int[] arr = {1,2,3,4,5};
        int[][] intervals = {{1,3},{0,4}};
        int[] solution = answer.solution(arr, intervals);
        System.out.println("solution = " + solution);


    }

}
