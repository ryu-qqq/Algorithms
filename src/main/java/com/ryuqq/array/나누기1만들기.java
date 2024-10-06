package com.ryuqq.array;



public class 나누기1만들기 {

    public int solution(int[] num_list) {
        int answer = 0;
        for(Integer num : num_list){
            answer += divideWithHalf(num, 0);
        }
        return answer;
    }

    private int divideWithHalf(int num, int count){
        while(num > 1){
            if(num % 2 == 0){
                num /= 2;
            }else{
                num = (num - 1) /2;
            }
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        나누기1만들기 answer = new 나누기1만들기();
        int[] num_list = {12, 4, 15, 1, 14};
        int solution = answer.solution(num_list);
        System.out.println("solution = " + solution);


    }
}
