package com.linkedlist;

public class LC2807 {

    public static void main(String[] args) {
        ListNode node = new ListNode(18);
        ListNode newHead = insertGreatestCommonDivisors(node);
        printLL(newHead);
    }

    private static void printLL(ListNode newHead) {
        ListNode node = newHead;
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode current = head;
        ListNode prev = null;

        while(current!=null){
            if(prev!=null){
                temp.next = new ListNode(findGCD(current.val, prev.val));
                temp=temp.next;
            }
            temp.next = new ListNode(current.val);
            temp= temp.next;
            prev = current;
            current=current.next;
        }
        return dummy.next;
    }

    public static int findGCD(int a, int b){
            while(a > 0 && b > 0) {
                if(a > b) {
                    a = a % b;
                }
                else {
                    b = b % a;
                }
            }
            if(a == 0) {
                return b;
            }
            return a;
    }
}
