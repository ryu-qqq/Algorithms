package com.ryuqq.inflean.sliding;

import java.util.Scanner;

public class 최대길이연속수열 {

    public static int solution(int[] arr, int target){
        int answer = 0;
        int start;
        for(int i =0; i < arr.length; i++){
            int count = target;
            int length = 0;

            start = i;
            while(start < arr.length){
                if(arr[start] == 1){
                    length++;
                }

                if(arr[start] == 0){
                    if(count > 0){
                        count--;
                        length++;
                    }else{

                        answer = Math.max(answer, length);
                        break;
                    }
                }
                start++;
            }

        }

        return answer;
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
