package com.ryuqq.string;

import java.util.Arrays;

public class 문자열잘라서정렬 {

    public String[] solution(String myString) {

        String[] split = myString.split("x");
        return Arrays.stream(split)
                .filter(s -> !s.isEmpty())
                .sorted()
                .toArray(String[]::new);
    }


    public static void main(String[] args) {
        문자열잘라서정렬 answer = new 문자열잘라서정렬();
        String[] dxccxbbbxaaaas = answer.solution("dxccxbbbxaaaa");
        System.out.println("dxccxbbbxaaaas = " + dxccxbbbxaaaas);

    }

}
