package com.linkedlist;

import java.util.*;

public class Lc23MergeKSortedList {

    
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
     }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        
        ListNode[] listNodes = {head1,head2,head3};
        Lc23MergeKSortedList mergeKSortedList = new Lc23MergeKSortedList();
        ListNode result = mergeKSortedList.mergeKLists(listNodes);

        printList(result);
    }

    private static void printList(ListNode result) {
          ListNode tempNode = result;
          while(tempNode!=null){
              System.out.println(tempNode.val);
              tempNode=tempNode.next;
          }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1,v2)->v1.val-v2.val);
        ListNode first = new ListNode();
        ListNode temp = first;
        for(ListNode node: lists){
            if(node!=null){
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            temp.next = smallest;
            if(smallest.next!=null){
                pq.add(smallest.next);
            }
            temp=temp.next;
        }
        return first.next;
    }

}
