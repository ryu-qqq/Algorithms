package com.ryuqq.programers.combination;

import java.util.*;

public class 모음사전 {

    private static final List<String> words = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;

        String[] alphabet = new String[]{"A", "E", "I", "O", "U"};

        dfs("", alphabet);
        Collections.sort(words);

        return words.indexOf(word) + 1;
    }


    public void dfs(String prefix, String[] alphabet){
        if(prefix.length() > 5){
            return;
        }

        if (!Objects.equals(prefix, "")) {
            words.add(prefix);
        }

        for (String s : alphabet) {
            dfs(prefix + s, alphabet);
        }
    }

    public static void main(String[] args) {
        모음사전 solution = new 모음사전();
        System.out.println(solution.solution("AAAAE"));  // 출력: 6
    }
}
