package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 문장속단어 {

    public static String solution(String word){
        String answer = "";

        String[] split = word.split(" ");
        for(String s : split){
            if(s.length() > answer.length()) answer = s;
        }

        return answer;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(solution(input1));

    }


}
