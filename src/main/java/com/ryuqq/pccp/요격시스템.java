package com.ryuqq.pccp;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {

    public int solution(int[][] targets) {
        int answer = 0;
        double lastInterceptPosition = -1;

        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

        for(int i = 0; i < targets.length; i++) {
            int[] target = targets[i];
            int start = target[0];
            int end = target[1];

            if(lastInterceptPosition < start){
                answer++;
                lastInterceptPosition = end - 0.5;
            }

        }

        return answer;
    }
}
