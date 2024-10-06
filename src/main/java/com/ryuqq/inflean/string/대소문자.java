package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 대소문자 {

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(Character.isUpperCase(c)){
                sb.append(String.valueOf(c).toLowerCase());
            }else{
                sb.append(String.valueOf(c).toUpperCase());

            }
        }
        return sb.toString();
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String s = solution(input1);
        System.out.println(s);
    }



}
