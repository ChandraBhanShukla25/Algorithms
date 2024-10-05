package com.linkedlist;

import java.math.BigDecimal;

public class LC2816Double {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {


        int arr[] = {1,8,9};

        LC2816Double lc2816Double = new LC2816Double();
        ListNode head = lc2816Double.createList(arr);
                ListNode newHead = lc2816Double.doubleIt(head);
        lc2816Double.print(newHead);

    }

    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }

        String a = sb.reverse().toString();
        int m = a.length() - 1;
        int carry = 0;
        StringBuilder product = new StringBuilder();
        for (int i = 0; i <= m; ++i) {
            int x = a.charAt(i)*2;
            carry= carry+x;
            int y = carry%10-'0';
            product.append(y);
            carry=carry/10;
        }

        String s = product.reverse().toString();
        System.out.println(s);
        int i = 0;
        ListNode dummy = new ListNode(0);
        ListNode temp1 = dummy;
        while (i < s.length()) {
            temp1.next = new ListNode(s.charAt(i));
            i++;
            temp1 = temp1.next;
        }
        return dummy.next;
    }

    public void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
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
