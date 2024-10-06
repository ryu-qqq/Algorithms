package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 유효한팰린드롬 {

    public static boolean solution(String s){


        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : charArray){
            if(Character.isLetter(c)){
                sb.append(c);
            }
        }

        String newWord = sb.toString();

        int start = 0;
        int end = newWord.length() - 1;


        while (start <= end) {
            String s1 = String.valueOf(newWord.charAt(start));
            String s2 = String.valueOf(newWord.charAt(end));

            if(s1.equalsIgnoreCase(s2)){
                start++;
                end--;
            }else {
                return false;
            }
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
