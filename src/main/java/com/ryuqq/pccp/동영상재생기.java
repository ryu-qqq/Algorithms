package com.ryuqq.pccp;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class 동영상재생기 {

    public String getMinSec(LocalTime localTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");
        return localTime.format(formatter);
    }

    public LocalTime getLocalTime(int min, int sec){
        return LocalTime.of(0, min, sec);
    }

    public LocalTime doNext(LocalTime videoRunningTime, LocalTime currentTime){
        LocalTime nextTenSecTime = currentTime.plusSeconds(10);
        if(videoRunningTime.isBefore(nextTenSecTime)){
            return videoRunningTime;
        }

        return nextTenSecTime;
    }

    public LocalTime doPrev(LocalTime currentTime) {
        if (currentTime.isBefore(LocalTime.of(0, 0, 10))) {
            return LocalTime.of(0, 0, 0);
        }

        return currentTime.minusSeconds(10);
    }

    public boolean isBetweenOpening(LocalTime currentTime, LocalTime start, LocalTime end) {
        return (currentTime.equals(start) || currentTime.isAfter(start)) && currentTime.isBefore(end);
    }

    public int[] getMinSecArr(String time){
        String[] split = time.split(":");
        int minute = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[1]);
        return new int[] {minute, second};
    }


    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] videoLen = getMinSecArr(video_len);
        int[] currentPos = getMinSecArr(pos);
        int[] openingStartPos = getMinSecArr(op_start);
        int[] openingEndPos = getMinSecArr(op_end);


        LocalTime videoRunningTime = getLocalTime(videoLen[0], videoLen[1]);
        LocalTime currentTime = getLocalTime(currentPos[0], currentPos[1]);
        LocalTime start = getLocalTime(openingStartPos[0], openingStartPos[1]);
        LocalTime end = getLocalTime(openingEndPos[0], openingEndPos[1]);

        if(isBetweenOpening(currentTime, start, end)){
            currentTime = end;
        }

        for(String s :commands){
            if(s.equals("next")){
                currentTime = doNext(videoRunningTime, currentTime);
            }else if(s.equals("prev")){
                currentTime = doPrev(currentTime);
            }
            if(isBetweenOpening(currentTime, start, end)){
                currentTime = end;
            }
        }

        return getMinSec(currentTime);
    }





    public static void main(String[] args) {
        동영상재생기 answer = new 동영상재생기();
        String[] arr = new String[] {"prev", "next", "next"};
        String solution = answer.solution("10:55", "00:05", "00:15", "06:55", arr);
        System.out.println(solution);
    }
}
