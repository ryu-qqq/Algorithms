package com.ryuqq.inflean.sliding;

import java.util.Scanner;

public class 두배열합치기 {

    public static int[] solution(int[] arr1, int[] arr2) {
        int[] answer =new int[arr1.length+arr2.length];

        int start1 = 0;
        int start2 = 0;

        for(int i =0; i<arr1.length + arr2.length; i ++){
            if(start1 == arr1.length){
                answer[i] = arr2[start2];
                start2++;
            }

            else if(start2 == arr2.length){
                answer[i] = arr1[start1];
                start1++;
            }

            else if(arr1[start1] < arr2[start2]){
                answer[i] = arr1[start1];
                start1++;
            }
            else {
                answer[i] = arr2[start2];
                start2++;
            }
        }



        return answer;
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = in.nextInt();
        }

        int m = in.nextInt();

        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = in.nextInt();
        }

        int[] solution = solution(arr1, arr2);

        for(Integer i : solution){
            System.out.print(i+ " ");
        }

    }


}
