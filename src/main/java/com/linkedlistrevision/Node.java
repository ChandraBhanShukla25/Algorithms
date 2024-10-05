package com.linkedlistrevision;

public class Node {
    int data;
    Node next;

    Node(int data, Node node){
        this.data=data;
        this.next=node;
    }

    Node(int data){
        this.data=data;
        this.next= null;
    }
}
