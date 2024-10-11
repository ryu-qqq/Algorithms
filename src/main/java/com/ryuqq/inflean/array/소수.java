package com.ryuqq.inflean.array;

import java.util.Arrays;
import java.util.Scanner;

public class 소수 {

    public static int solution(int input){
        int count = 0;
        boolean[] isPrime = new boolean[input + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= input; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= input; j += i){
                    isPrime[j] = false;
                }
            }
        }

        for(boolean b : isPrime){
            if(b) count++;
        }


        return count;

    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int solution = solution(input1);
        System.out.print(solution);

    }

}
