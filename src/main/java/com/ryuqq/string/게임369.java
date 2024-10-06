package com.ryuqq.string;

public class 게임369 {

    public int solution(int order) {
        int answer = 0;

        for(char c : String.valueOf(order).toCharArray()) {
            if(c == '3') answer++;
            if(c == '6') answer++;
            if(c == '9') answer++;
        }

        return answer;
    }


}
