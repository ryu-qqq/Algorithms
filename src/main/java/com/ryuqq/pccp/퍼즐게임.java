package com.ryuqq.pccp;

public class 퍼즐게임 {

    private boolean canSolveAll(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;

        totalTime += times[0];

        for (int i = 1; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = times[i - 1];

            if (diff <= level) {
                totalTime += timeCur;
            } else {
                int mistakes = diff - level;
                totalTime += mistakes * (timeCur + timePrev) + timeCur;
            }

            if (totalTime > limit) {
                return false;
            }
        }

        return totalTime <= limit;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;

        while (left < right) {
            int mid = (left + right) / 2;

            if (canSolveAll(diffs, times, limit, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        퍼즐게임 answer = new 퍼즐게임();

        int[] arr1= new int[]{1, 5, 3};
        int[] arr2= new int[]{2, 4, 7};

        int solution = answer.solution(arr1, arr2, 30);
        System.out.println("solution = " + solution);
    }
}
