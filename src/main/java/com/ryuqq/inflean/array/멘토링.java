package com.ryuqq.inflean.array;

import java.util.*;

public class 멘토링 {

    public static int solution(int[][] arr, int n, int m){
        int count = 0;
        for(int i =1; i<=n; i++){
            for(int j =1; j<=n; j++){

                boolean flag = true;
                for(int k=0; k<m; k++){
                    int rankA = 0;
                    int rankB = 0;

                    for(int l=0; l<n; l++){
                        if(arr[k][l] == i) rankA = l;
                        if(arr[k][l] == j) rankB = l;
                    }

                    if(rankA >= rankB){
                        flag = false;
                        break;
                    }

                }

                if(flag) count++;
            }
        }


        return count;
    }



    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[m][n];
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                arr[i][j]=in.nextInt();
            }
        }
        int solution = solution(arr, n, m);
        System.out.println(solution);
    }
}
