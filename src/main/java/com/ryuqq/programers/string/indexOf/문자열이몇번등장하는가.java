package com.ryuqq.programers.string.indexOf;

/**
 * String class의 indexOf Api를 사용해서 풀 수 있다.

 *
 public int indexOf(String str, int fromIndex) {
 return indexOf(value, coder(), length(), str, fromIndex);
 }

 *  ch의 문자를 fromIndex부터 검색 후 일치하면 해당 단어가 시작하는 위치를 반환
 *  없다면 -1을 반환

 */


public class 문자열이몇번등장하는가 {

    public int solution(String myString, String pat) {
        int answer = 0;

        for(int i =0; i<=myString.length(); i++) {
            int start = i;
            int end = i + pat.length();

            if(end > myString.length()) {
                break;
            }

            String substring = myString.substring(start, end);
            if(substring.equals(pat)){
                answer++;
            }
        }

        return answer;
    }


    public int solution2(String myString, String pat) {
        int answer = 0;
        int start = 0;

        while ((start = myString.indexOf(pat, start)) != -1) {
            answer++;
            start += 1;
        }

        return answer;
    }


    public static void main(String[] args) {
        문자열이몇번등장하는가 answer =   new 문자열이몇번등장하는가();
        String myString = "banana";
        String pat = "ana";

        int solution = answer.solution2(myString, pat);
        System.out.println("solution = " + solution);
    }




}
