package com.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC2416 {
    Node root;

    public LC2416(){
        this.root = new Node();
    }
    static class Node{
        Map<Character, Node> children = new HashMap<>();
        int count = 0;
    }

    public int score(String word){
        int score = 0;
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.children.containsKey(ch)){
                node = node.children.get(ch);
                score+=node.count;
            }
        }
        return score;
    }

    public void insert(String word) {
     Node node = root;
     for(char ch: word.toCharArray()){
         node.children.putIfAbsent(ch, new Node());
         node = node.children.get(ch);
         node.count++;
     }
    }

    private int[] sumPrefixScores(String[] words) {
        int[] scores = new int[words.length];
        for(String word:words){
            insert(word);
        }
        int i=0;
        for(String word:words){
            scores[i]= score(word);
            i++;
        }
        return scores;
    }

    public static void main(String[] args) {
      String[] words = {"abc","ab","bc","b"};
      LC2416 lc2416 = new LC2416();
      int[] arr = lc2416.sumPrefixScores(words);
      Arrays.stream(arr).forEach(System.out::println);
    }


}
