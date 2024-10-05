package com.linkedlist;

public class LC83RemoveDuplicates {

      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode deleteDuplicates(ListNode head) {
          ListNode temp = head;
          ListNode slow = temp;
          ListNode fast = temp.next;
          while(fast!=null && slow!=null){
              if(fast.val==slow.val){
                  slow.next= slow.next.next;
                  fast = fast.next;
              }else{
                  slow =slow.next;
                  fast = fast.next;
              }
          }
          return temp;
    }
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next= new ListNode(1);
      head.next.next = new ListNode(2);
      LC83RemoveDuplicates removeDuplicates = new LC83RemoveDuplicates();
      ListNode temp = removeDuplicates.deleteDuplicates(head);

      while(temp!=null){
          System.out.println(temp.val);
          temp=temp.next;
      }


    }
}
