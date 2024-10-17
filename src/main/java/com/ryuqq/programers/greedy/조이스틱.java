package com.ryuqq.programers.greedy;

public class 조이스틱 {

    public int solution(String name) {
        int answer = 0;

        int length = name.length();
        for(int i =0; i<length; i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int minMove = length - 1; // 오른쪽 끝까지 쭉 이동하는 경우
        for(int i =0; i < length; i ++){
            int next = i + 1;

            while(next < length && name.charAt(next) == 'A'){
                next++;
            }

            minMove = Math.min(minMove, i + length - next + Math.min(i, length - next));

        }
        answer += minMove;

        return answer;
    }

}
