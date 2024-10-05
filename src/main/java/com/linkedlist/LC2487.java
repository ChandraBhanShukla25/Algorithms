package com.linkedlist;

import java.util.*;

public class LC2487 {

    
     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }
    public static void main(String[] args) {
         //5,2,13,3,8
        ListNode head = new ListNode(5);
        head.next=new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        LC2487 lc2487 = new LC2487();
        ListNode newHead = lc2487.removeNodes(head);
        lc2487.print(newHead);
     }

     public void print(ListNode head){
         ListNode temp = head;
         while(temp!=null){
             System.out.println(temp.val);
             temp=temp.next;
         }
     }
    //5->2->13->3->8
    public ListNode removeNodes(ListNode head) {
      List<Integer> lst = new ArrayList<>();
      ListNode current = head;
      while(current!=null){
          lst.add(current.val);
          current=current.next;
      }

      ArrayDeque<Integer> stack = new ArrayDeque<>();
      for(Integer curr: lst){
          while(!stack.isEmpty() && stack.peek()<curr){
              stack.pop();
          }
          stack.push(curr);
      }

      ListNode dummy=new ListNode(0);
      ListNode temp = dummy;
      while(!stack.isEmpty()){
          temp.next = new ListNode(stack.pollLast());
          temp=temp.next;
      }
      return dummy.next;
    }
}
