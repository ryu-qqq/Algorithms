package com.ryuqq.inflean.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 단어뒤집기 {


    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i =str.length() -1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int count = in.nextInt();
        for(int i =0; i<=count; i++){
            String input1 = in.nextLine();
            list.add(solution(input1));
        }

        for(String s : list) {
            if(s.isEmpty()) continue;
            System.out.println(s);
        }
    }


}
