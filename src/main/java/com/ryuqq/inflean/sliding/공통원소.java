package com.ryuqq.inflean.sliding;

import java.util.*;

public class 공통원소 {

    public static List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        int start1 = 0;
        int start2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);



        for(int i =0; i<arr1.length + arr2.length; i ++){
            if(start1 == arr1.length || start2 == arr2.length){
                break;
            }

            int i1 = arr1[start1];
            int i2 = arr2[start2];

            if(i1 == i2){
                list.add(i1);
                start1++;
                start2++;
            }else{
                if(i1 > i2){
                    start2++;
                }
                else {
                    start1++;
                }
            }
        }

        return list;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = in.nextInt();
        }

        int m = in.nextInt();

        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = in.nextInt();
        }

        List<Integer> solution = solution(arr1, arr2);

        for(Integer i : solution){
            System.out.print(i+ " ");
        }

    }
}
