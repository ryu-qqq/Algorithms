package com.ryuqq.combination;


import java.util.Arrays;

public class Permutation {
    public static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            permutation(arr, depth + 1, n, r);
            swap(arr, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, 0, arr.length, 2);  // 3개 중 2개를 뽑는 순열
    }
}

