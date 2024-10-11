package com.ryuqq.inflean.stack;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {

    public static boolean solution(String s){

        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c.equals('(')){
                stack.push(c);
            }else if(c.equals(')')){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        boolean solution = solution(s);
        String answer = solution ? "YES" : "NO";
        System.out.print(answer);
    }


}
