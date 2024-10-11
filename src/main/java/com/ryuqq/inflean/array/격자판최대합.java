package com.ryuqq.inflean.array;

import java.util.Scanner;

public class 격자판최대합 {

    public static int solution(int[][] arr){
        int answer = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            int temp = 0;
            for(int j=0;j<arr[i].length;j++){
                temp += arr[i][j];
            }
            answer = Math.max(temp, answer);
        }

        for(int i=0;i<arr.length;i++){
            int temp = 0;
            for(int j=0;j<arr[i].length;j++){
                temp += arr[j][i];
            }
            answer = Math.max(temp, answer);
        }


        for(int i =0;i<arr.length;i++){
            int temp = 0;
            for(int j=0;j<arr[i].length;j++){
                if(i == j){
                    temp += arr[i][j];
                }
            }
            answer = Math.max(temp, answer);
        }

        for(int i =0;i<arr.length;i++){
            int temp = 0;
            for(int j=arr.length -1; j >=0; j--){
                if(i + j == arr.length - 1){
                    temp += arr[j][i];
                }
            }
            answer = Math.max(temp, answer);
        }


        return answer;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int input1 = in.nextInt();
        int[][] arr = new int[input1][input1];
        for(int i =0; i<input1; i++){
            for(int j =0; j<input1; j++){
                arr[i][j]=in.nextInt();
            }
        }

        int answer  = solution(arr);
        System.out.print(answer);
    }

}
