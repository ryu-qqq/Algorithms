package com.ryuqq.pccp;

import java.util.Arrays;
import java.util.Objects;

public class 공원 {

    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        int[][] squares = new int[park.length][park[0].length];
        int maxLength = 0;

        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length; j++) {
                if(Objects.equals(park[i][j], "-1")) {

                    if(i ==0 || j == 0){
                        squares[i][j] = 1;
                    }else{
                        squares[i][j] = Math.min(Math.min(squares[i-1][j], squares[i][j-1]), squares[i-1][j-1]) + 1;
                    }

                    maxLength = Math.max(maxLength, squares[i][j]);
                }
            }
        }


        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            if (mats[i] <= maxLength) {
                return mats[i];
            }
        }
        return answer;
    }


}
