package com.ryuqq.kakao;

import java.util.*;

public class 주사위고르기 {

    private static List<int[]> generateCombinations(int n, int half) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[half];
        combine(combinations, combination, 0, 0, n, half);
        return combinations;
    }

    private static void combine(List<int[]> combinations, int[] combination, int idx, int start, int n, int half) {
        if (idx == half) {
            combinations.add(combination.clone());
            return;
        }

        for (int i = start; i < n; i++) {
            combination[idx] = i;
            combine(combinations, combination, idx + 1, i + 1, n, half);
        }
    }

    public int[] solution(int[][] dice) {
        int length = dice.length;
        int half = length / 2;
        int maxWins = -1;
        int[] result = {};

        List<int[]> aCombination = generateCombinations(length, half);

        for (int[] aDices : aCombination) {
            Set<Integer> allDices = new HashSet<>();
            for (int i = 0; i < length; i++) {
                allDices.add(i);
            }

            for (int diceIdx : aDices) {
                allDices.remove(diceIdx);
            }


            int[] bDices = allDices.stream().mapToInt(Integer::intValue).toArray();

            int winCount = calculateOutcomes(aDices, bDices, dice);


            if(maxWins < winCount){
                maxWins = winCount;
                result = aDices;
            }

        }

        return Arrays.stream(result).map(i -> i + 1).toArray();
    }


    private static int calculateOutcomes(int[] aDices, int[] bDices, int[][] dice) {
        int wins = 0;

        List<Integer> allARolls = getAllRolls(aDices, dice);
        List<Integer> allBRolls = getAllRolls(bDices, dice);

        Collections.sort(allARolls);
        Collections.sort(allBRolls);


        for(int aSum : allARolls){
            int winIndex = binarySearch(allBRolls, aSum);
            wins += winIndex;
        }

        return wins;
    }

    private static int binarySearch(List<Integer> allBRolls, int aSum) {
        int left = 0, right = allBRolls.size();
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(allBRolls.get(mid) < aSum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }


    private static List<Integer> getAllRolls(int[] diceIndexes, int[][] dice) {
        List<Integer> sums = new ArrayList<>();
        sumDfs(diceIndexes, dice, 0, 0, sums);
        return sums;
    }

    private static void sumDfs(int[] diceIndexes, int[][] dice, int idx, int sum , List<Integer> sums){
        if(idx == diceIndexes.length){
            sums.add(sum);
            return;
        }

        int diceIndex = diceIndexes[idx];
        int[] die = dice[diceIndex];

        for (int face : die) {
            sumDfs(diceIndexes, dice, idx + 1, sum + face, sums);
        }

    }


    public static void main(String[] args) {
        주사위고르기 answer = new 주사위고르기();
        int[][] dice = {
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        };
        answer.solution(dice);

    }
}
