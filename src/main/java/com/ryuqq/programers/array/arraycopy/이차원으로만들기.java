package com.ryuqq.programers.array.arraycopy;

/**
 * 이중 포문으로도 풀 수 있지만 arraycopy api를 사용해서 풀수도 있다
 *
 * 장점:
 * 내부적으로 **JNI(Java Native Interface)**를 통해 C 언어로 작성된 네이티브 코드를 호출하여 실행. 이 과정에서 메모리 레벨에서 데이터를 한 번에 블록 단위로 복사.
 *
 * public static void arraycopy(
 *     Object src,      // 원본 배열
 *     int srcPos,      // 원본 배열에서 복사 시작 위치
 *     Object dest,     // 대상 배열
 *     int destPos,     // 대상 배열에 붙여넣기 시작할 위치
 *     int length       // 복사할 요소의 수
 * )
 *
 */


public class 이차원으로만들기 {


    public int[][] solution(int[] num_list, int n) {

        int length = num_list.length / n;

        int[][] answer = new int[length][n];

        for (int i=0; i<length; i++) {
            System.arraycopy(num_list, i * n, answer[i], 0, n);
        }

        return answer;
    }

    public static void main(String[] args) {
        이차원으로만들기 temp = new 이차원으로만들기();

        int[] num_list1 = {1, 2, 3, 4, 5, 6, 7, 8};

        int[][] solution = temp.solution(num_list1, 2);
        System.out.println("solution = " + solution);
    }

}
