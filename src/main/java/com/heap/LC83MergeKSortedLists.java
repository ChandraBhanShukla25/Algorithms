package com.heap;

import com.trie.Node;

import java.util.PriorityQueue;

public class LC83MergeKSortedLists {

    
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next= new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next= new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode l3 = new ListNode(2);
        l3.next= new ListNode(6);

        ListNode[] lists = {l1,l2,l3};
        LC83MergeKSortedLists mergeKSortedLists = new LC83MergeKSortedLists();
        ListNode result = mergeKSortedLists.mergeKLists(lists);
        ListNode current = result;
        while(current!=null){
            System.out.println(current.val);
            current=current.next;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2)-> node1.val-node2.val);
        for(ListNode node : lists){
            if(node!=null){
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            if(smallest.next!=null){
                pq.add(smallest.next);
            }
            current.next = smallest;
            current = current.next;
        }
        return dummy.next;
    }
}
