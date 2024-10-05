package com.linkedlistrevision;

import java.util.Arrays;
import java.util.List;

public class LinkedListBasic {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        System.out.println("Initial state of LinkedList");
        print(head);
        System.out.println("After new head linked list state");
        Node newHead = insertHead(head,val);
        print(newHead);
        System.out.println("After delete last node linked list state");
        Node afterDeleteList = deleteLast(newHead);
        print(afterDeleteList);
        int length = findLength(afterDeleteList);
        System.out.println("length of linked List" + length);

        boolean found = searchElement(afterDeleteList, 100);
        System.out.println("Is 100 exist -- " + found);

        boolean found7 = searchElement(afterDeleteList, 7);
        System.out.println("Is 7 exist -- " + found7);


        Node newNode = new Node(5);
        System.out.println("print when only 1 node");
        print(newNode);
        System.out.println("Delete when only 1 node");
        Node afterDeleteOnlyOneNode = deleteLast(newNode);
        print(afterDeleteOnlyOneNode);
    }

    public static boolean searchElement(Node head, int val){
        Node current = head;
        while(current!=null){
            if(val == current.data){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    private static int findLength(Node node) {
        Node current = node;
        int length = 0;
        if(current==null){
            return 0;
        }
        while(current!=null){
            length++;
            current=current.next;
        }
        return  length;
    }

    private static Node deleteLast(Node newHead) {
        Node current = newHead;
        if(current==null || current.next==null){
            return null;
        }

        while(current.next.next!=null){
            current = current.next;
        }

        current.next=null;

        return newHead;
    }

    public static void print(Node head){
        Node current = head;
        if(current==null){
            System.out.println("null");
            return;
        }
        while(current!=null){
            System.out.print(current.data + " , ");
            current=current.next;
        }
        System.out.println();
    }

    public static Node insertHead(Node head, int val){
        Node newHead = new Node(val, head);
        return newHead;
    }
}
