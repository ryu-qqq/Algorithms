package com.ryuqq.combination;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for(int width = 1; width <= total; width++) {
            if(total % width == 0){
                int height = total / width;

                if(width >= height){
                    if((width - 2) * (height - 2) == yellow){
                        return new int[]{width, height};
                    }
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        카펫 answer= new 카펫();
        int[] solution = answer.solution(10, 2);
        System.out.println("solution = " + solution);
    }


}
