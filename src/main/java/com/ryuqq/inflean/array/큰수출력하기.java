package com.ryuqq.inflean.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 큰수출력하기 {

    public static List<Integer> solution(int[] arr){

        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for(int i =1; i< arr.length; i++){
            if(arr[i] > arr[i - 1]){
                list.add(arr[i]);
            }
        }

        return list;
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i]=in.nextInt();
        }

        List<Integer> list = solution(arr);
        for(Integer integer : list){
            System.out.print(integer + " ");
        }

    }
}
