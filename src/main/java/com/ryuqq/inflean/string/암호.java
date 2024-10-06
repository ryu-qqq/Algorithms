package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 암호 {

    public static String solution(int num, String s){
        StringBuilder result = new StringBuilder();



        int len = s.length() / num;
        for(int i = 0; i < num; i++){
            String substring = s.substring(i * len, len * (i + 1));
            StringBuilder sb = new StringBuilder();
            for(char c : substring.toCharArray()){
                String s1 = String.valueOf(c);
                if(s1.equals("#")){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }

            int decimal = Integer.parseInt(sb.toString(), 2);

            result.append((char) decimal);
        }




        return result.toString();
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        String input1 = in.nextLine();
        String solution = solution(num, input1);
        System.out.println(solution);

    }
}
