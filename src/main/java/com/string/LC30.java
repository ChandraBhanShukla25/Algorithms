package com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {
    public static void main(String[] args) {
        String s= "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> lst = findSubstring(s, words);
        System.out.println(lst);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
      List<Integer> result = new ArrayList<>();
      if(s==null || s.isEmpty() ||  words==null || words.length==0) return result;
      int wordCount = words.length;
      int wordLength = words[0].length();
      int totalWordLength = wordLength*wordCount;
      int concatenatedStringLength = s.length();

      Map<String, Integer> wordMap = new HashMap<>();
      for(String word:words){
          wordMap.merge(word,  1, Integer::sum);
      }

      for(int i=0;i<=concatenatedStringLength-totalWordLength; i++){
          HashMap<String, Integer> seenWords = new HashMap<>();

          int j=0;
          while(j<wordCount){
              int wordIndex = i+j*wordLength;
              String word = s.substring(wordIndex, wordIndex+wordLength);

              if(!wordMap.containsKey(word))
                  break;

              seenWords.merge(word, 1, Integer::sum);
              if(seenWords.get(word)>wordMap.get(word)){
                  break;
              }
              j++;
          }
          if(j==wordCount){
              result.add(i);
          }
      }

     return result;
    }
}
