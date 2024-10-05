package com.linkedlist;

import java.util.LinkedList;

public class RemoveZeros {


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        //[1,2,-3,3,1]
        listNode.next= new ListNode(2);
        listNode.next.next = new ListNode(-3);
        listNode.next.next.next= new ListNode(3);
        listNode.next.next.next.next = new ListNode(1);
        RemoveZeros removeZeros = new RemoveZeros();
        ListNode current = removeZeros.removeZeroSumSublists(listNode);

        while (current!=null){
            System.out.print(current.val + "  ");
            current=current.next;
        }

    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode current = new ListNode(0, head);
       ListNode slow = current;
       while(slow!=null){

           ListNode fast=slow.next;
           int prefixSum = 0;
           while(fast!=null){
             prefixSum= prefixSum+fast.val;
             if(prefixSum==0){
                 slow.next = fast.next;
             }
             fast = fast.next;
           }
           slow = slow.next;
       }
      return current.next;
    }
}
