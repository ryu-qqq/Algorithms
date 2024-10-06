package com.ryuqq.programers.combination;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        int[] aArr = {1, 2, 3, 4, 5};
        int[] bArr = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cArr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        aCount = hit(answers, aArr, aCount);
        bCount = hit(answers, bArr, bCount);
        cCount = hit(answers, cArr, cCount);

        int maxCount = Math.max(aCount, Math.max(bCount, cCount));

        List<Integer> list = new ArrayList<>();

        if(maxCount == aCount) list.add(1);
        if(maxCount == bCount) list.add(2);
        if(maxCount == cCount) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }

    private int hit(int[] answers, int[] arr, int count){
        for(int i = 0; i < answers.length; i++) {
            int idx = i % arr.length;
            if(answers[i] == arr[idx]) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        모의고사 answer = new 모의고사();
        answer.solution(new int[]{1,3,2,4,2});

    }

}
