package com.ryuqq.queue_stack.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 올바른괄호 {

    //
    boolean solution1(String s) {
        while(true){
            if(String.valueOf(s.toCharArray()[0]).equals(")")) return false;
            if(String.valueOf(s.toCharArray()[s.length()-1]).equals("(")) return false;

            if(!s.contains("()")) {
                if(s.length() > 1) return false;
            }else{
                 s = s.replace("()", "");
                 if(s.isEmpty()) return true;
            }
        }
    }

    boolean solution2(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        if(String.valueOf(charArray[0]).equals(")"))return false;
        if(String.valueOf(charArray[charArray.length-1]).equals("("))return false;

        for(int i =0; i < s.length(); i++){
            if(s.length() == 1) return false;
            String word = String.valueOf(charArray[i]);
            if(word.equals("(")) stack.push(word);
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        if(!stack.isEmpty()) return false;

        return answer;
    }


    public static void main(String[] args) {
        올바른괄호 answer = new 올바른괄호();
        String s = "(";
        boolean solution = answer.solution1(s);
        System.out.println("solution = " + solution);

    }
}
