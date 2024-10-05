package com.linkedlist;

public class MiddleNode {
    
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;
      }
   }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);


        ListNode midNode = middleNode(node1);
        System.out.println(midNode.val);
    }

    public  static ListNode middleNode(ListNode head) {


          ListNode fast = head;
          ListNode slow = head;

          while(fast!=null && fast.next!=null && slow!=null){
              fast = fast.next.next;
              slow = slow.next;
          }
       return slow;
    }
}
