package com.ryuqq.inflean.string;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 중복문자제거 {

    public static String solution(String s){
        Set<String> set = new LinkedHashSet<>();
        for(char c : s.toCharArray()){
            set.add(String.valueOf(c));
        }

        StringBuilder sb = new StringBuilder();
        set.forEach(sb::append);

        return sb.toString();
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String solution = solution(input1);
        System.out.println(solution);
    }
}
