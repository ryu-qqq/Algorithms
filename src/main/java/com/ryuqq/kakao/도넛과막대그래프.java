package com.ryuqq.kakao;

import java.util.*;

public class 도넛과막대그래프 {
    private static final int length = 1000000;
    private static int[] outGoing = new int[length + 1];
    private static int[] inGoing = new int[length + 1];

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        for (int[] edge : edges) {
            int startPoint = edge[0] - 1;
            int endPoint = edge[1] - 1;

            outGoing[startPoint]++;
            inGoing[endPoint]++;
        }
        int created = 0;
        int stick =0;
        int eight = 0;

        for(int i = 0; i < length; i++) {

            if(outGoing[i] >=2){
                if(inGoing[i] == 0){
                    created = i;
                }else{
                    eight++;
                }

            }
            else if(outGoing[i] == 0 && inGoing[i] > 0){
                stick++;
            }
        }


        return new int[] {created + 1, outGoing[created] - eight - stick, stick, eight};
    }






    public static void main(String[] args) {
        도넛과막대그래프 answer= new 도넛과막대그래프();
        int [][] input = {{2,3},{4,3},{1,1}, {2,1}};
        int[] solution = answer.solution(input);
        System.out.println(solution);
    }

}
