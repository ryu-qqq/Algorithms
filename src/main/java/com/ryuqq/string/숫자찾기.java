package com.ryuqq.string;

public class 숫자찾기 {

    public int solution(int num, int k) {
        int answer = -1;
        String StringNum = String.valueOf(num);
        for(int i =0; i< StringNum.length(); i++) {
            char c = StringNum.charAt(i);
            if(String.valueOf(c).equals(String.valueOf(k))) return i + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        숫자찾기 answer = new 숫자찾기();
        int solution = answer.solution(29183, 1);
        System.out.println("solution = " + solution);
    }

}
