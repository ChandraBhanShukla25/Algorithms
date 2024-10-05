package com.linkedlist;

public class LC61LinkedList {

    public static void main(String[] args) {
      ListNode head  = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      LC61LinkedList lc61LinkedList = new LC61LinkedList();
      lc61LinkedList.rotateRight(head,2);
    }
// 1 2 3 4 5
    // 3 4 5 1 2
    public ListNode rotateRight(ListNode head, int k) {
      ListNode dummy = new ListNode(0, head);

      while(k>=0){
          ListNode current = head;
          ListNode prev = head;
          while(current.next!=null){
              current=current.next;
          }
          current.next=prev;
          head = prev.next;
          prev.next=null;
          k--;
      }
      printLL(head);
      return head;
    }

    public void printLL(ListNode node){
        while(node!=null){
          System.out.println(node.val);
            node=node.next;
        }
    }
}
