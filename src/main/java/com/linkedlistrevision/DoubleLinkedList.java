package com.linkedlistrevision;

public class DoubleLinkedList {

    public static void main(String[] args) {
      DoubleNode head = new DoubleNode(5);
        System.out.println("print DLL");
       printDLL(head);
       DoubleNode newHead = insertAtHead(head, 1);
       System.out.println("Print after inserting at head;");
        printDLL(newHead);
        System.out.println("Print after inserting at tail");
        insertAtTail(newHead , 10);
        printDLL(newHead);
        
        newHead = deleteAtHead(newHead, 2);
    }

    private static DoubleNode deleteAtHead(DoubleNode newHead, int i) {
        DoubleNode current = newHead;
        if(i==1){
            DoubleNode newH = current.next;
            current.next=null;
            newH.back=null;
            return newH;
        }else{
            int k = 0;

            while( current.next!=null && current.next.next!=null && k<i-1){
                current=current.next;
                i++;
            }
            current.next = current.next.next;
            current.next.back = current.back;
            return newHead;
        }

    }


    public static DoubleNode insertAtHead(DoubleNode head,int data){
        DoubleNode newHead = new DoubleNode(data, null, head);
        newHead.next = head;
        head.back=newHead;
        head = newHead;
        return head;
    }

    public static DoubleNode insertAtTail(DoubleNode head, int data){
        DoubleNode current = head;
        while(current.next!=null){
            current=current.next;
        }
        DoubleNode newNode = new DoubleNode(data, current, null);
        current.next = newNode;
        newNode.back = current;
        return head;
    }

    public static void printDLL(DoubleNode head){
        DoubleNode current = head;
        while(current!=null){
            System.out.print(current.data + " , ");
            current=current.next;
        }
        System.out.println();
    }

}
