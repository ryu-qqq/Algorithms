package com.ryuqq.inflean.sliding;

import java.util.Scanner;

public class 연속부분수열 {

    public static int solution(int[] arr , int target){
        int count = 0;
        int sum;

        for(int i = 0 ; i < arr.length ; i++){
            int position = i;
            sum = 0;

            while(position < arr.length){

                sum += arr[position];
                if(sum == target){
                    count++;
                    break;
                }

                if(sum > target){
                    break;
                }

                position++;

            }


        }


        return count;
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

//        int[] arr = {1, 2, 1, 3, 1, 1, 1, 2};
        int answer = solution(arr, target);
        System.out.print(answer);
    }
}
