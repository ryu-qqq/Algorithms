package com.ryuqq.inflean.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피보나치 {

    public static List<Integer> solution(int input){
        List<Integer> list = new ArrayList<>();

        int i1 = 1;
        int i2 = 1;

        list.add(i1);
        list.add(i2);

        for(int i=2; i<input; i++){
            Integer i3 = list.get(list.size() - 2);
            Integer i4 = list.getLast();
            list.add(i3 + i4);
        }

        return list;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        List<Integer> solution = solution(input1);
        for(int s : solution){
            System.out.print(s + " ");
        }
    }

}
