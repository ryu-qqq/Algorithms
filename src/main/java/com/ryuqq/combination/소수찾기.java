package com.ryuqq.combination;

import java.util.*;

public class 소수찾기 {

    public int solution(String numbers) {

        Set<Integer> set = new HashSet<>();
        char[] charArray = numbers.toCharArray();
        boolean[] visited = new boolean[charArray.length];

        numberCombination(charArray, "", visited, set);

        return (int) set.stream().filter(this::isPrime).count();
    }

    private void numberCombination(char[] charArray, String prefix, boolean[] visited, Set<Integer> set) {

        if(!Objects.equals(prefix, "")) {
            set.add(Integer.parseInt(prefix));
        }

        for(int i = 0; i< charArray.length; i++){
            if(!visited[i]){
                visited[i] = true;
                numberCombination(charArray, prefix + charArray[i], visited, set);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num){
        if(num <= 1) return false;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        소수찾기 answer = new 소수찾기();
        answer.solution("17");
    }



}
