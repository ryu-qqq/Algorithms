package com.ryuqq.array;

public class 등차수열특정항더하기 {

    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i =0; i < included.length; i++) {
            if(included[i]){
                answer += a + (d * i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        등차수열특정항더하기 answer = new 등차수열특정항더하기();
        boolean[] included ={true, false, false, true, true};
        answer.solution(3, 4, included);
    }

}
