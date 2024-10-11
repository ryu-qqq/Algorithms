package com.ryuqq.inflean.array;

import java.util.Scanner;

public class 봉우리 {

    public static int solution(int[][] arr, int row){
        int answer = 0;

        for(int i=1;i<=row;i++){
            for(int j=1;j<=row;j++){
                int dest = arr[i][j];

                int x1 = arr[i - 1][j];
                int x2 = arr[i + 1][j];
                int y1 = arr[i][j - 1];
                int y2 = arr[i][j + 1];
                if(dest > x1 && dest > x2 && dest > y1 && dest > y2){
                    answer++;
                }

            }
        }


        return answer;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int input1 = in.nextInt();
        int[][] arr = new int[input1 + 2][input1 + 2];
        for(int i =1; i<=input1; i++){
            for(int j =1; j<=input1; j++){
                arr[i][j]=in.nextInt();
            }
        }

        int answer  = solution(arr, input1);
        System.out.print(answer);
    }
}
