package com.ryuqq;

public class 합성수찾기 {

    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int count = 1;
            for(int j = i; j > 1; j--){
                if(i % j ==0) count++;
                if(count >=3) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
