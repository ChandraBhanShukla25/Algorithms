package com.trie;

public class Node {

    Node[] links = new Node[26];
    boolean flag = false;

    public void insert(char ch, Node node){
        links[ch-'a']= node;
    }

    public boolean isEnd(){
        return flag;
    }

    public void setEnd(){
        this.flag=true;
    }
    public boolean contains(char ch){
        return links[ch-'a']!=null;
    }

    public Node get(char ch){
        return  links[ch-'a'];
    }
}
