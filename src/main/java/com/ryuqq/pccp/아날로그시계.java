package com.ryuqq.pccp;

public class 아날로그시계 {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int count = 0;

        int startSeconds = h1 * 3600 + m1 * 60 + s1;
        int endSeconds = h2 * 3600 + m2 * 60 + s2;

        for (int time = startSeconds; time <= endSeconds; time++) {
            int hour = (time / 3600) % 12;
            int minute = (time / 60) % 60;
            int second = time % 60;

            double hourAngle = (hour * 30) + (minute * 0.5);
            double minuteAngle = minute * 6;
            double secondAngle = second * 6;

            if (Math.abs(secondAngle - hourAngle) < 1e-9 || Math.abs(secondAngle - minuteAngle) < 1e-9) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        아날로그시계 answer = new 아날로그시계();
        int solution = answer.solution(0, 5, 30, 0, 7, 0);
        System.out.println("solution = " + solution);
    }


}
