package com.linkedlist;

public class CheckPalindrome {
    
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
          // head = [1,2,2,1]
          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(2);
          head.next.next.next = new ListNode(1);
          CheckPalindrome checkPalindrome = new CheckPalindrome();
          checkPalindrome.isPalindrome(head);

    }

    public boolean isPalindrome(ListNode head) {

          ListNode slow = head;
          ListNode fast = head;

          while(fast!=null){
              slow=slow.next;
              fast=fast.next.next;
          }

          ListNode reverseHead = reverse(slow);
          ListNode midHead = reverseHead;
          ListNode temp = head;

          while(midHead!=null){
              if(midHead.val!=temp.val){
                  return false;
              }
              midHead=midHead.next;
              temp=temp.next;
          }
          boolean val = true;
          reverse(slow);
          return val;
    }


    public ListNode reverse(ListNode newHead){
        if(newHead==null){
            return null;
        }
        if(newHead.next==null){
            return newHead;
        }
        ListNode revereseHead = reverse(newHead.next);
        newHead.next.next=newHead;
        newHead.next = null;
        return revereseHead;
    }
}
