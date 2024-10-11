package com.ryuqq.inflean.sliding;

import java.util.List;
import java.util.Scanner;

public class 최대매출 {

    public static int solution(int[] arr, int interval){
        int answer;
        int start = 0;
        int sum = 0;

        for(int i =0; i<interval; i++){
            sum += arr[i];
        }

        answer = sum;

        for(int i = interval; i<arr.length; i++){
            int toMinus = arr[start];
            int toPlus = arr[i];

            sum -= toMinus;
            sum += toPlus;
            start++;

            answer = Math.max(answer, sum);
        }

        return answer;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int interval = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        int answer = solution(arr, interval);
        System.out.print(answer);
    }
}
