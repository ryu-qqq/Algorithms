package com.ryuqq.programers.queue_stack.stack;

import java.util.*;

public class 같은숫자싫어 {

    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for (Integer i : arr) {
            if (stack.isEmpty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        같은숫자싫어 sol = new 같은숫자싫어();
        int[] result = sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println(Arrays.toString(result));
    }


}
