package com.ryuqq.string;

public class k의개수 {


    public int solution(int i, int j, int k) {
            int answer = 0;
            for(int q = i; q <= j; q++){
                String target = String.valueOf(q);
                String kString = String.valueOf(k);

                for(char c : target.toCharArray()){
                    if(c == kString.charAt(0)) answer ++;
                }
            }
            return answer;
    }



    public static void main(String[] args) {
        k의개수 answer = new k의개수();
        int solution = answer.solution(1, 13, 1);
        System.out.println("solution = " + solution);

    }


}
