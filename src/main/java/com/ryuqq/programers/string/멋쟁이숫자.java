package com.ryuqq.programers.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 멋쟁이숫자 {


    public int solution(String s) {
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < s.length()-3; i++) {
            String substring = s.substring(i, 3 + i);
            char c1 = substring.charAt(0);
            char c2 = substring.charAt(1);
            char c3 = substring.charAt(2);

            if(c1 == c2 && c2 == c3) {
                list.add(Integer.valueOf(substring));
            }
        }

        if(list.isEmpty()) return -1;

        list.sort(Comparator.reverseOrder());

        return list.getFirst();
    }


    public static void main(String[] args) {
        멋쟁이숫자 answer =new 멋쟁이숫자();
        int solution = answer.solution("123");
        System.out.println("solution = " + solution);
    }

}
