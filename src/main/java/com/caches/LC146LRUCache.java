package com.caches;

import java.util.HashMap;
import java.util.SortedMap;

public class LC146LRUCache {

    Node head ;
    Node tail ;
    int capacity ;
    HashMap<Integer, Node> cache;
    LC146LRUCache (int capacity){
        this.capacity=capacity;
        this.cache= new HashMap<>();
        this.tail=new Node(0,0);
        this.head = new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
     static class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

     int get(int key){
        Node node = cache.get(key);
        if(node!=null){
            remove(node);
            insert(node);
            return node.val;
        }else{
            return -1;
        }
    }

     void put(int key, int val){
        Node node = cache.get(key);
        if(node!=null){
            remove(node);
        }
        if(cache.size()>=capacity){
            remove(tail.prev);
        }
        insert(new Node(key, val));
    }

    public void insert(Node newNode){
        cache.put(newNode.key,newNode);
        newNode.next = head.next;
        newNode.next.prev=newNode;
        head.next=newNode;
        newNode.prev=head;
    }

    public void remove(Node node){
        cache.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public static void main(String[] args) {
      LC146LRUCache lruCache = new LC146LRUCache(2);
      lruCache.put(1,1);
      lruCache.put(2,2);
      System.out.println(lruCache.get(1));
      lruCache.put(3,3);
      System.out.println(lruCache.get(2));
      lruCache.put(4,4);
        System.out.println(lruCache.get(1));


    }
}
