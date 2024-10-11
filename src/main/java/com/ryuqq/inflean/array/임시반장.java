package com.ryuqq.inflean.array;

import java.util.*;

public class 임시반장 {

    public static int solution(int[][] arr, int n){
        int answer = Integer.MIN_VALUE;
        int student = 0;
        //i 학생
        for(int i =1; i <=n; i++){
            //학년 돌면서
            int count = 0;
            for(int j =1; j <=n; j++){
                for(int k =1; k <=5; k++){
                    int i1 = arr[i][k];
                    int i2 = arr[j][k];
                    if(i1 == i2){
                        count ++;
                        break;
                    }
                }
            }

            if(answer < count){
                answer = count;
                student = i;
            }
        }
        return student;
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n + 1][6];
        for(int i =1; i<=n; i++){
            for(int j =1; j<=5; j++){
                arr[i][j]=in.nextInt();
            }
        }

        int solution = solution(arr, n);
        System.out.println(solution);
    }
}




