package com.ryuqq.inflean.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {

    public static boolean solution(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();



        for(char c : s1.toCharArray()) {
            String lowerCase = String.valueOf(c).toLowerCase();
            map.put(lowerCase, map.getOrDefault(lowerCase, 0) + 1);
        }

        for(char c : s2.toCharArray()) {
            String lowerCase = String.valueOf(c).toLowerCase();
            map.put(lowerCase, map.getOrDefault(lowerCase, 0) - 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) return false;
            if(entry.getValue() < 0) return false;

        }

        return true;
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        boolean solution = solution(s1, s2);
        String answer = solution ? "YES" : "NO";
        System.out.print(answer);
    }
}
