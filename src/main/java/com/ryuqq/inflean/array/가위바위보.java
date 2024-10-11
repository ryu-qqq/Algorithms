package com.ryuqq.inflean.array;

import java.util.Scanner;

public class 가위바위보 {
    //1 가위 2 바위 3 보
    public static String rockScissorsPaper(int a, int b){
        if(a == b) return "D";
        if(a == 1 && b == 2) return "B";
        if(a == 1 && b == 3) return "A";
        if(a == 2 && b == 1) return "A";
        if(a == 2 && b == 3) return "B";
        if(a == 3 && b == 1) return "B";
        return "A";
    }

    public static String[] solution(int[] arrA, int[] arrB){

        String[] answer = new String[arrA.length];

        for(int i = 0; i < arrA.length; i++){
            int i1 = arrA[i];
            int i2 = arrB[i];
            String s = rockScissorsPaper(i1, i2);
            answer[i] = s;
        }

        return answer;

    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arrA = new int[input1];
        int[] arrB = new int[input1];

        for(int i=0; i<input1; i++){
            arrA[i]=in.nextInt();
        }

        for(int i=0; i<input1; i++){
            arrB[i]=in.nextInt();
        }

        String[] solution = solution(arrA, arrB);
        for(String s : solution){
            System.out.println(s);
        }
    }


}
