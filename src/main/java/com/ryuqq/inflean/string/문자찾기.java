package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 문자찾기 {

    public static int solution(String word, String str) {
        int answer = 0;
        for(char c : word.toCharArray()){
            if(String.valueOf(c).equalsIgnoreCase(str)) answer++;
        }

        return answer;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();

        int solution = solution(input1, input2);
        System.out.println(solution);
    }

}
