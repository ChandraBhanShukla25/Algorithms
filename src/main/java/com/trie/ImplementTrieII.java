package com.trie;

public class ImplementTrieII {

     Node root;
     static class Node{
         Node[] node = new Node[26];
         int prefix;
         int endsWith;

         boolean flag = false;

         public void put(char ch, Node newNode){
             node[ch-'a']= newNode;
         }

         public void setEnd(){
             this.flag = true;
         }

         public boolean containsKey(char ch){
             return node[ch-'a']!=null;
         }

         public boolean isEnd(){
             return flag;
         }

         public Node get(char ch){
             return node[ch-'a'];
         }
     }

     ImplementTrieII(Node node){
         this.root = node;
     }

     public void insert(String word){
         Node node = root;

         for(int i=0;i<word.length();i++){
             char ch = word.charAt(i);
             if(!node.containsKey(ch)){
                 node.put(ch, new Node());;
             }
             node = node.get(ch);
             node.prefix++;
         }
         node.setEnd();
         node.endsWith++;
     }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        return node.endsWith;
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        return node.prefix;
    }


    public void erase(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                break;
            }
            node = node.get(ch);
            node.prefix--;
        }
         node.endsWith--;
    }

    public static void main(String[] args) {
         Node node = new Node();
        ImplementTrieII trie = new ImplementTrieII(node);
        trie.insert("apple");
        trie.insert("app");
        System.out.println("Inserting strings 'apple', 'app' into Trie");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'app' from trie");
        trie.erase("app");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'apple': ");
        System.out.println(trie.countWordsStartingWith("app"));

        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsStartingWith("app"));
    }
}
