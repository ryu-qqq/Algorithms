package com.ryuqq.pccp;

public class 연속된부분수열합 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int left = 0;
        int right =0;
        int length = Integer.MAX_VALUE;
        int sum =sequence[0];

        while(right < sequence.length){
            if(sum == k){
                int diff = right - left;
                if(diff < length){
                    length = diff;
                    answer = new int[]{left, right};
                }
                sum -= sequence[left];
                left++;

            }else if(sum < k){
                right++;
                if(right < sequence.length){
                    sum += sequence[right];
                }

            }else{
                sum -= sequence[left];
                left++;
            }

        }

        return answer;
    }





    public static void main(String[] args) {
        연속된부분수열합 answer = new 연속된부분수열합();
        int[] arr = {1,2,3,4,5};
        int[] solution = answer.solution(arr, 7);
        System.out.println("solution = " + solution);
    }



}
