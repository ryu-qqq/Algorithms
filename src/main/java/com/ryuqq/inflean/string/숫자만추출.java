package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 숫자만추출 {

    public static int solution(String s){

        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        int solution = solution(input1);
        System.out.println(solution);
    }

}
