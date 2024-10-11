package com.ryuqq.inflean.map;

import java.util.*;

public class 학급회장 {

    public static String solution(int n , String s){
        String chairMan = "";
        Map<String, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0) + 1);
        }

        int answer = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            if(answer < value){
                answer = value;
                chairMan = entry.getKey();
            }
        }

        return chairMan;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String arr = in.nextLine();
        String answer = solution(n, arr);
        System.out.print(answer);
    }

}
