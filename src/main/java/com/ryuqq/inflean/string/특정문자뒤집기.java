package com.ryuqq.inflean.string;

import java.util.Arrays;
import java.util.Scanner;

public class 특정문자뒤집기 {


    public static String solution(String word){
        String[] arr = new String[word.length()];
        int start =0;
        int end = word.length()-1;

        while(start <= end){

            if(!Character.isAlphabetic(word.charAt(start))){
                arr[start] = String.valueOf(word.charAt(start));
                start++;
            }

            else if(!Character.isAlphabetic(word.charAt(end))){
                arr[end] = String.valueOf(word.charAt(end));
                end --;
            }


            if(Character.isAlphabetic(word.charAt(end)) && Character.isAlphabetic(word.charAt(start))){
                char temp = word.charAt(start);
                arr[start] = String.valueOf(word.charAt(end));
                arr[end] = String.valueOf(temp);
                start ++;
                end --;
            }

        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(sb::append);

        return sb.toString();
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String solution = solution(input1);
        System.out.println(solution);
    }
}
