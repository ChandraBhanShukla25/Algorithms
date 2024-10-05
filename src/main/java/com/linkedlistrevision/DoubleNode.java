package com.linkedlistrevision;

public class DoubleNode {

    int data;
    DoubleNode back;
    DoubleNode next;

    public DoubleNode(int data, DoubleNode back, DoubleNode next){
        this.data=data;
        this.back = back;
        this.next= next;
    }

    public DoubleNode(int data){
        this.data=data;
    }
}
