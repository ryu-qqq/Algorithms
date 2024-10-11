package com.ryuqq.inflean.array;

import java.util.Scanner;

public class 점수계산 {

    public static int solution(int[] arr){
        int count = 0;
        boolean flag = false;
        int isContinue = 1;

        for(Integer i : arr){
            if(i == 1){
                count ++;
                if(flag){
                    count += isContinue;
                    isContinue++;
                }else{
                    flag = true;
                }
            }else{
                flag = false;
                isContinue = 1;
            }
        }


        return count;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for(int i =0; i<input1; i++){
            arr[i]=in.nextInt();
        }
        int answer = solution(arr);
        System.out.print(answer);

    }
}
