package com.ryuqq.programers.string;

/**
 * 아스키 코드 숫자를 기억해야한다.
 * a 가 0, b가 1 ...
 * 0이 48
 * 1이 49
 */


public class 외계행성나이 {

    public String solution(int age) {
        StringBuilder result = new StringBuilder();
        String stringAge = String.valueOf(age);

        for(char c : stringAge.toCharArray()){
            result.append((char) ('a' + (c - '0')));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        외계행성나이 answer = new 외계행성나이();
        String solution = answer.solution(0);
        System.out.println("solution = " + solution);
    }
}
