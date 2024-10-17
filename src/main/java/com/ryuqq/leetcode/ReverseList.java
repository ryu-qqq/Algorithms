package com.ryuqq.leetcode;

public class ReverseList {


    public void reverseString(char[] s) {
        reverse(s, 0);
    }

    public void reverse(char[] s, int depth){
        if(s.length / 2 < depth){
            return;
        }

        swap(s, depth, s.length - depth - 1);
        reverse(s, depth + 1);
    }


    private void swap(char[] s, int a, int b){
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }


    public static void main(String[] args) {
        ReverseList reverseString = new ReverseList();
        char[] s = {'h','e','l','l','o'};
        reverseString.reverseString(s);
        System.out.println(s);
    }

}
