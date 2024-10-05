package com.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC472 {

    public static void main(String[] args) {
        String words[] = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        LC472 lc472 = new LC472();
        List<String> result = lc472.findAllConcatenatedWordsInADict(words);
        System.out.println(result);
    }

    private Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words){
        Arrays.sort(words, (a,b)->a.length()-b.length());
        List<String> result = new ArrayList<>();
        for(String word: words){
            if(isConcatenated(word)){
                result.add(word);
            }else{
                trie.insert(word);
            }
        }
        return result;
    }

    public boolean isConcatenated(String word){
        if(word.isEmpty())
            return true;

        Trie node = trie;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(node.children[index]==null){
                return false;
            }
            node = node.children[index];

            if(node.isEndOfWord && isConcatenated(word.substring(i+1)))
                return true;
        }
        return false;
    }

    static  class Trie{
        Trie[] children = new Trie[26];
        boolean isEndOfWord;

        public void insert(String word){
            Trie node = this;

            for(char ch: word.toCharArray()){
                int index = ch-'a';
                if(node.children[index]==null){
                    node.children[index]=new Trie();
                }
                node = node.children[index];
            }
            node.isEndOfWord=true;
        }

    }
}
