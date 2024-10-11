package com.ryuqq.inflean.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든아나그램 {

    public static int solution(String s1, String s2) {
        int answer = 0;
        int interval = s2.length();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i =0; i<interval; i++){
            Character key = s2.charAt(i);
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }


        for(int i =0; i<interval; i++){
            Character key = s1.charAt(i);
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }


        if(map1.equals(map2)) answer ++;

        for(int i =interval; i < s1.length(); i++){
            Character s = s1.charAt(i);
            map1.put(s, map1.getOrDefault(s, 0) + 1);

            Character toRemove = s1.charAt(i - interval);
            Integer value = map1.getOrDefault(toRemove, 0);

            if(value == 1){
                map1.remove(toRemove);
            }else{
                map1.put(toRemove, value - 1);
            }


            if(map1.equals(map2)) answer ++;

        }

        return answer;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int answer = solution(s1, s2);
        System.out.print(answer);

    }
}
