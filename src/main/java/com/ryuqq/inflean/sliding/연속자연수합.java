package com.ryuqq.inflean.sliding;

import java.util.Scanner;

public class 연속자연수합 {

    public static int solution(int target){
        int count = 0;
        int start = 1;
        int sum;

        int[] arr = new int[target + 1];

        for(int i =1; i <= target;i++){
            arr[i] = i;
        }

        for(int i =1; i<=target; i++){
            sum = 0;
            start = i;
            while(start <= target){

                if(target == arr[start]){
                    break;
                }

                sum += arr[start];


                if(sum == target){
                    count++;
                    break;
                }

                if(sum > target){
                    break;
                }


                start++;
            }

        }





        return count;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int target = in.nextInt();

        int answer = solution(target);
        System.out.print(answer);
    }

}
