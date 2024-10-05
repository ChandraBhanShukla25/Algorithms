package com.trie;

public class TrieNode {

    Node root;

    TrieNode(Node node){
        this.root = node;
    }

    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.contains(ch)){
                node.insert(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean searchWord(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return  node.flag;
    }

    public boolean containsPrefix(String prefix){
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
        String s1 = "apple";
        String s2 = "apps";
        String s3 = "appl";
        String s4 = "apple";
        Node node = new Node();
        TrieNode trieNode = new TrieNode(node);
        trieNode.insert(s1);
        boolean wordExist = trieNode.searchWord(s2);
        System.out.println(s2 + "  S2 exist:: " + wordExist);
        boolean isPrefix = trieNode.containsPrefix(s3);
        System.out.println(s3 +" contains prefix s3:: " + isPrefix);

        boolean wordExist1 = trieNode.searchWord(s4);
        System.out.println(s4 + " is exist " + wordExist1);

    }


}
