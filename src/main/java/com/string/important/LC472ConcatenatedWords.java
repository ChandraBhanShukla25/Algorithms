package com.string.important;

import java.util.*;


public class LC472ConcatenatedWords {

    public static void main(String[] args) {
      String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
      LC472ConcatenatedWords concatenatedWords = new LC472ConcatenatedWords();
      List<String> listOfWords = concatenatedWords.findAllConcatenatedWordsInADict(words);
      System.out.println(listOfWords);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        HashSet<String> result = new HashSet<>();
        HashSet<String> finalResult = new HashSet<>();
        findWords(words, 0, words.length, "", result, finalResult);
        finalResult.retainAll(set);
        System.out.println(finalResult);
        return new ArrayList<>(finalResult);
    }

    private void findWords(String[] words, int idx,int n, String str, HashSet<String> result, HashSet<String> finalResult) {
        if(idx>=words.length){
            Set<String> res = new HashSet<>(result);
            finalResult.addAll(res);
            return;
        }
        str+=words[idx];
        result.add(str);
        findWords(words, idx+1,n, str,  result, finalResult);
        result.remove(result.size()-1);
        findWords(words, idx,n, str,  result, finalResult);

    }
}
