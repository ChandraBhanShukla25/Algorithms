package com.trie;

public class LC208ImplementTrie {
    Node root ;
    class Node{
        Node[] node;
        boolean flag=false;

        Node(){
            node = new Node[26];
        }

        public void put(char ch, Node newNode){
            node[ch-'a']=newNode;
        }

        public Node get(char ch){
            return node[ch-'a'];
        }

        public void setEnd(){
            flag = true;
        }

        public boolean contains(char ch){
            return node[ch-'a']!=null;
        }

        public boolean isEnd(){
            return flag;
        }



    }

    public LC208ImplementTrie(){
        this.root = new Node();
    }




    public void insert(String word) {
       Node node =  root;

       for(int i=0;i<word.length();i++){
           char ch = word.charAt(i);
           if(!node.contains(ch)){
           node.put(ch, new Node());
           }
           node = node.get(ch);
       }
       node.setEnd();
    }

    public boolean search(String word) {
       Node node = root;

       for(int i=0;i<word.length();i++){
           char ch = word.charAt(i);
           if(!node.contains(ch)){
               return false;
           }
           node = node.get(ch);
       }
       return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        LC208ImplementTrie trie = new LC208ImplementTrie();
        System.out.println("Inserting words: Striver, Striving, String, Strike");
        trie.insert("cat");
        trie.insert("dog");
        trie.insert("catdog");

        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));
    }


}
