package com.ryuqq.array.arraycopy;

import java.util.Arrays;

public class 배열회전시키기 {

    public int[] solution(int[] numbers, String direction) {

        if(direction.equals("right")) {
            int temp = numbers[numbers.length - 1];
            System.arraycopy(numbers, 0, numbers, 1, numbers.length -1);
            numbers[0] = temp;
        }else{
            int temp = numbers[0];
            System.arraycopy(numbers, 1, numbers, 0, numbers.length -1);
            numbers[numbers.length -1] = temp;
        }
        return numbers;
    }

    public static void main(String[] args) {
        //int[] numbers = {4, 455, 6, 4, -1, 45, 6};
        int[] numbers = {1, 2, 3};

        배열회전시키기 answer = new 배열회전시키기();
        int[] solution = answer.solution(numbers, "right");
        System.out.println("solution = " + solution);

    }

}
