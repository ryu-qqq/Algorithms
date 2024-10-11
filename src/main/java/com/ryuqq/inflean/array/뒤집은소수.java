package com.ryuqq.inflean.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 뒤집은소수 {


    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }

    public static boolean isPrime(int reverseNumber) {
        if (reverseNumber < 2) return false;
        for(int i = 2;i <= Math.sqrt(reverseNumber); i++) {
            if(reverseNumber % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> solution(List<Integer> list){

        List<Integer> result = new ArrayList<>();

        for(Integer num : list) {
            int i = reverseNumber(num);
            if(isPrime(i)){
                result.add(i);
            }
        }

        return result;
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int input1 = in.nextInt();
        for(int i =0; i<input1; i++){
            list.add(in.nextInt());
        }
        List<Integer> solution = solution(list);
        for(Integer i : solution){
            System.out.print(i + " ");
        }
    }

}
