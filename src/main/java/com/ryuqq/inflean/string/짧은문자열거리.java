package com.ryuqq.inflean.string;

import java.util.Scanner;

public class 짧은문자열거리 {

    public static int[] solution(String str, String target) {
        int[] arr =new int[str.length()];

        int left = 0;
        int count =1;

        while(left < str.length()){
            String s = String.valueOf(str.charAt(left));
            if(s.equals(target)){
                arr[left] = 0;
                count = 1;
            }else{
                arr[left] = count;
                count++;
            }
            left++;

        }

        count =1;
        int right = str.length() - 1;

        while(right >=0){
            String s = String.valueOf(str.charAt(right));
            if(s.equals(target)){
                arr[right] = 0;
                count = 1;
            }else{
                arr[right] = Math.min(arr[right], count);
                count++;
            }

            right--;

        }

        return arr;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();
        int[] solution = solution(input1, input2);
        for(int i : solution){
            System.out.print(i + " ");
        }

    }
}
