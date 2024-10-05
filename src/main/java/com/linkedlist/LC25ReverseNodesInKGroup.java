package com.linkedlist;

public class LC25ReverseNodesInKGroup {

    public static void main(String[] args) {
       int [] arr = {1,2,3,4,5};
       int k =2;
       LC25ReverseNodesInKGroup reverseNodesInKGroup = new LC25ReverseNodesInKGroup();
       ListNode head = reverseNodesInKGroup.createList(arr);
       ListNode reverseNoes = reverseNodesInKGroup.reverseKGroup(head,k);
       reverseNodesInKGroup.print(reverseNoes);

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode current = dummy;

        ListNode predec = dummy;
        while(current.next!=null){
           for(int i=0;i<k && current!=null;i++){
               current=current.next;
           }
           if(current==null){
               return dummy.next;
           }
           ListNode temp = current.next;
           ListNode start = predec.next;
           current.next=null;
           ListNode reverseNode = reverse(start);
           predec.next=reverseNode;
           start.next = temp;
           predec=start;
           current=predec;
        }


        return dummy.next;

    }

    public ListNode reverse(ListNode temp){
        ListNode current = temp;
        ListNode next = null;
        ListNode prev = null;
        while(current!=null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        temp = prev;
        return temp;
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
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
