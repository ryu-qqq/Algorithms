package com.ryuqq.inflean.stack;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {

    public static String solution(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }

            else if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }

            if(stack.isEmpty() && c != ')'){
                sb.append(c);
            }

        }



        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        String answer = solution(s);
        System.out.print(answer);
    }

}
