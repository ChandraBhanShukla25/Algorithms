package com.array;

import java.util.LinkedList;

public class MergeInBetweenLC1669 {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      }

//    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
//          ListNode temp1 = new ListNode();
//          temp1.next = list1;
//          for(int i=0;i<a;i++){
//              temp1 = temp1.next;
//              System.out.println(temp1.val);
//          }
//          return null;
//    }
//
//    public static void main(String[] args) {
//        LinkedList list1
//        list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
//    }
}
