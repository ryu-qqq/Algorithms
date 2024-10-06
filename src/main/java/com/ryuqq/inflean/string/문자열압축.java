package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 문자열압축 {

    public static String solution(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i =0;i< s.length(); i++){
            if(i < s.length() - 1){
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + 1);

                if(c1==c2){
                    count++;
                }else{
                    sb.append(s.charAt(i));
                    if(count>1){
                        sb.append(count);
                    }

                    count = 1;
                }
            }

        }

        sb.append(s.charAt(s.length() - 1));
        if (count > 1) {
            sb.append(count);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String solution = solution(input1);
        System.out.println(solution);
    }
}
