package com.ryuqq.leetcode;

public class SwapNode {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;


        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;


        return secondNode;
    }

    public ListNode arrayToList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }



    public static void main(String[] args) {

        SwapNode swapNode = new SwapNode();
        int[] arr = {1,2,3,4};

        ListNode head = swapNode.arrayToList(arr);
        swapNode.swapPairs(head);

    }

}
