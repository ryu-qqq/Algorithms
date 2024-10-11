package com.ryuqq.inflean.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 보이는학생 {

    public static int solution(int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i =1; i < arr.length; i++){

            Integer i1 = list.get(list.size() - 1);
            int i2 = arr[i];
            if(i1 < i2){
                list.add(i2);
            }
        }

        return list.size();
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i]=in.nextInt();
        }

        int answer =  solution(arr);
        System.out.println(answer);
    }
}
