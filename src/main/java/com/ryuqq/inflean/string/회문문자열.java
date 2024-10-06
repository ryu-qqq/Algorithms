package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 회문문자열 {

    public static boolean solution(String s){
        int start = 0;
        int end = s.length() - 1;


        while(start <= end){
            String c1 = String.valueOf(s.charAt(start));
            String c2 = String.valueOf(s.charAt(end));
            if(c1.equalsIgnoreCase(c2)){
                start++;
                end--;
            }
            else return false;
        }

        return true;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        boolean solution = solution(input1);
        String answer = solution ? "YES" : "NO";
        System.out.println(answer);
    }
}
