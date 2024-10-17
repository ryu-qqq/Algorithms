package com.ryuqq.kakao;


//111    1 + 2 + 4

//더미 0 더미 아니면 1
public class 표현가능한이진트리 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];


        for (int i = 0; i < numbers.length; i++) {

            String binaryString = Long.toBinaryString(numbers[i]);
            int treeHeight = getTreeHeight(binaryString.length());
            String tree = padBinaryToFull(binaryString, treeHeight);
            boolean validTree = isValidTree(tree);
            answer[i] = validTree ? 1 : 0;
        }
        return answer;
    }


    //2^h -1 = lengh
    public int getTreeHeight(int nodeCount){
        int height = 0;
        while(Math.pow(2, height) - 1 < nodeCount){
            height++;
        }
        return height;
    }

    public String padBinaryToFull(String binaryString, int treeHeight) {
        int fullLength = (int) Math.pow(2, treeHeight) - 1;
        int needToAdd = fullLength - binaryString.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needToAdd; i++) {
            sb.append("0");
        }
        sb.append(binaryString);
        return sb.toString();
    }


    public boolean isValidTree(String tree){
        return isDummyNode(tree, 0, tree.length() -1);
    }



    public boolean isDummyNode(String tree, int start, int end){
        if(start > end){
            return true;
        }

        int mid = (start + end) / 2;

        if(tree.charAt(mid) == '0'){
            for(int i = start; i <= end; i++){
                if(tree.charAt(i) == '1'){
                    return false;
                }
            }
        }

        return isDummyNode(tree, start, mid - 1) && isDummyNode(tree, mid + 1, end);
    }




    public static void main(String[] args) {
        표현가능한이진트리 answer = new 표현가능한이진트리();
        answer.solution(new long[]{5});
    }



}
