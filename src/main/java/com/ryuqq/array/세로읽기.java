package com.ryuqq.array;

public class 세로읽기 {
    public String solution(String my_string, int m, int c) {

        int row = my_string.length() / m;

        char[][] temp = new char[row][m];

        for(int i=0; i<row; i++){
            String substring = my_string.substring(m * i, (m * i) + m);

            for (int j=0; j<m; j++){
                temp[i][j] = substring.charAt(j);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(char[] chars : temp){
            stringBuilder.append(chars[c-1]);
        }

        return stringBuilder.toString();
    }

    public String solution2(String my_string, int m, int c) {
        StringBuilder result = new StringBuilder();

        // 세로로 c번째 열에 있는 문자들을 모음
        for (int i = 0; i < my_string.length(); i += m) {
            result.append(my_string.charAt(i + (c - 1)));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String myString = "ihrhbakrfpndopljhygc";
        세로읽기 answer = new 세로읽기();
        String solution = answer.solution2(myString, 4, 2);
        System.out.println("solution = " + solution);

    }

}
