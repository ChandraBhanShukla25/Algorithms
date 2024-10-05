package com.linkedlist;


public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode revL1 = l1;
        ListNode revL2 = l2;
        // print(revL2);
        int sum = 0;
        int carry = 0;
        ListNode temp = newNode;
        while (revL1 != null && revL2 != null) {
            sum = revL1.val + revL2.val;
            sum = sum + carry;
            temp.next = new ListNode(sum % 10);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            revL1 = revL1.next;
            revL2 = revL2.next;
            temp = temp.next;
        }
        while (revL1 != null) {
            sum = revL1.val ;
            sum = sum + carry;
            temp.next = new ListNode(sum % 10);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            revL1 = revL1.next;
            temp = temp.next;
        }

        while (revL2 != null) {
            sum = revL2.val;
            sum = sum + carry;
            temp.next = new ListNode(sum % 10);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            revL2 = revL2.next;
            temp = temp.next;
        }

        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1,l2);

        ListNode temp = result;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
}
