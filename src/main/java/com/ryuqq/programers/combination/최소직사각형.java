package com.ryuqq.programers.combination;

public class 최소직사각형 {

    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int masHeight = 0;

        for(int[] size: sizes) {
            if(size[0] < size[1]){
                swap(size);
            }

            maxWidth = Math.max(maxWidth, size[0]);
            masHeight = Math.max(masHeight, size[1]);
        }

        return maxWidth * masHeight;
    }


    private void swap(int[] arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        최소직사각형 answer = new 최소직사각형();
        int solution = answer.solution(sizes);
        System.out.println("solution = " + solution);
    }

}
