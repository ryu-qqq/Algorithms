package com.ryuqq.pccp;

public class 두원사이의정수쌍 {

    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long minY = (long) Math.ceil(Math.sqrt(Math.max(0, r1 * r1 - x * x)));
            long maxY = (long) Math.floor(Math.sqrt(r2 * r2 - x * x));

            if (minY <= maxY) {
                answer += (maxY - minY + 1);
            }
        }

        answer = answer * 4L;
        return answer;
    }

    public static void main(String[] args) {
        두원사이의정수쌍 answer = new 두원사이의정수쌍();
        long solution = answer.solution(2, 3);
        System.out.println("solution = " + solution);
    }

}
