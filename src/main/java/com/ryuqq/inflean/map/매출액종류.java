package com.ryuqq.inflean.map;

import java.util.*;

public class 매출액종류 {

    public static List<Integer> solution(int interval, int[] arr){
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        int start = 0;
        int end = interval;

        for(int i=0; i<interval; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        list.add(map.size());

        while(end < arr.length){
            map.put(arr[start], map.getOrDefault(arr[start], 0) - 1);
            if(map.get(arr[start]) <= 0){
                map.remove(arr[start]);
            }

            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            list.add(map.size());
            start++;
            end ++;
        }

        return list;
    }




    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int i1 = in.nextInt();
        int[] arr = new int[i1];
        int interval = in.nextInt();

        for(int i =0; i<i1; i++){
            arr[i]=in.nextInt();
        }

        List<Integer> solution = solution(interval, arr);
        for(Integer integer : solution){
            System.out.print(integer + " ");
        }

    }


}
