package com.trie;

import java.util.PriorityQueue;

public class LongestWordInAllPrefixes {

    static Node root = new Node();
    static class Node{
        Node[] node = new Node[26];
        boolean flag;

        void put(char ch, Node newNode){
            this.node[ch-'a']= newNode;
        }

        boolean contains(char ch){
            return node[ch-'a']!=null;
        }

        boolean isEnd(){
            return flag;
        }

        boolean setEnd(){
            return this.flag = true;
        }

        Node get(char ch){
            return node[ch-'a'];
        }
    }

    public static void main(String[] args) {
        String s= "aa";
        int count = countDistinctSubstrings(s);
        // adding 1 for empty string
        System.out.println(count);
    }

    public static int countDistinctSubstrings(String s)
    {
        int count = 0;

        for(int i=0;i<s.length(); i++){
            Node node = root;
            for(int j=i; j<s.length(); j++) {
                char ch = s.charAt(j);
                if (!node.contains(ch)) {
                    count++;
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
        }

        return count+1;
    }
}
