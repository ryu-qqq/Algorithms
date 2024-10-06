package com.ryuqq.programers.array.copyOf;

import java.util.Arrays;

/**
 * Arrays.copyOf() 이 API는 배열의 크기를 늘려도, 남은 부분에 0이 자동으로 채워집니다.
 *
 */



public class 배열2제곱만들기 {

    public int[] solution(int[] arr) {

        int goal = 1;
        int length = arr.length;

        while(length > goal){
            goal *= 2;
        }

        return Arrays.copyOf(arr, goal);
    }

    public static void main(String[] args) {
        배열2제곱만들기 answer = new 배열2제곱만들기();

        int[] arr = {1,2,3};

        int[] solution = answer.solution(arr);
        System.out.println("solution = " + solution);

    }
}
