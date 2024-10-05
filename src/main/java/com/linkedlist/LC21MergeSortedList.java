package com.linkedlist;

public class LC21MergeSortedList {
    
    
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          ListNode head = new ListNode(0);
        ListNode merge = head;
        while(list1!=null && list2!=null){
            if(list1.val>=list2.val){
                merge.next = new ListNode(list2.val);
                list2= list2.next;
                merge=merge.next;
            }else{
                merge.next = new ListNode(list1.val);
                list1 = list1.next;
                merge=merge.next;
            }
        }

        while(list1!=null){
            merge.next = new ListNode(list1.val);
            list1=list1.next;
            merge=merge.next;

        }

        while(list2!=null){
            merge.next=new ListNode(list2.val);
            list2=list2.next;
            merge=merge.next;
        }

        return head.next;

    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        LC21MergeSortedList lc21 = new LC21MergeSortedList();
         ListNode head = lc21.mergeTwoLists(head1,head2);

         while(head!=null){
             System.out.println(head.val);
             head=head.next;
         }


    }
}
