package com.ryuqq.programers.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 문자열정렬2 {

    public String solution(String my_string) {

        String[] split = my_string.split("");
        return Arrays.stream(split)
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.joining());
    }
}
