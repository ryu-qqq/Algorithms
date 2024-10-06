package com.ryuqq.greedy;

public class 체육복 {


    public int solution(int n, int[] lost, int[] reserve) {

        int[] arr = new int[n + 1];

        for(int i : reserve) {
            arr[i]++;
        }

        for(int i : lost) {
            arr[i]--;
        }

        for(int i = 1; i <= n; i++) {
            if(arr[i] == -1) {
                if(i > 1 && arr[i - 1] == 1) {
                    arr[i]++;
                    arr[i-1]--;
                }else if(i < n && arr[i + 1] == 1) {
                    arr[i]++;
                    arr[i+1]--;
                }
            }
        }

        int answer = 0;
        for(int i =1; i <= n; i++) {
            if(arr[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }

}
