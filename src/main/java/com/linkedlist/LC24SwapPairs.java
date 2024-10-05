package com.linkedlist;

public class LC24SwapPairs {

      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
         if(head==null || head.next==null){
             return head;
         }

        ListNode current = head;
        ListNode prev = null;
        while(current!=null && current.next!=null){
            if(current==head){
                ListNode temp = current;
                ListNode temp2 = current.next;
                ListNode temp3 = current.next.next;
                temp.next=temp3;
                head = temp2;
                temp2.next=temp;
                prev=temp;
                current = current.next;
            } else{
                ListNode temp = current;
                ListNode temp2 = current.next;
                ListNode temp3 = current.next.next;
                prev.next =temp2;
                temp2.next = temp;
                temp.next = temp3;
                current = temp.next;
                prev = temp;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        LC24SwapPairs swapPairs = new LC24SwapPairs();
        ListNode head = swapPairs.createList(arr);
        ListNode newHead = swapPairs.swapPairs(head);
        swapPairs.print(newHead);

    }

    private void print(ListNode newHead) {

          ListNode temp = newHead;
          while(temp!=null){
              System.out.println(temp.val);
              temp=temp.next;
          }
    }

    public ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int i = 0;
        while (i < arr.length) {
            temp.next = new ListNode(arr[i]);
            i++;
            temp = temp.next;
        }
        return dummy.next;
    }


}
