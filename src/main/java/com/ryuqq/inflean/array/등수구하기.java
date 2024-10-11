package com.ryuqq.inflean.array;

import java.util.*;

public class 등수구하기 {

    public static List<Integer> solution(int[] arr){

        List<Integer> results = new ArrayList<>();

        for(int i=0; i<arr.length;i++){
            int rank = 1;
            for(int j=0; j<arr.length;j++){
                if(i ==j )continue;
                if(arr[i] < arr[j]){
                    rank++;
                }
            }

            results.add(rank);
        }


        return results;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for(int i =0; i<input1; i++){
            arr[i]=in.nextInt();
        }

        List<Integer> results = solution(arr);
        for(Integer i : results){
            System.out.print(i + " ");
        }


    }

}
