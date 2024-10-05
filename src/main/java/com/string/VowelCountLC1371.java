package com.string;

import java.util.HashMap;
import java.util.Map;

public class VowelCountLC1371 {

    public static void main(String[] args) {
       String str = "eleetminicoworoep";
       int x = findTheLongestSubstring(str);
        System.out.println(x);
    }

    public static int findTheLongestSubstring(String s) {
      if(s.isEmpty()){
          return 0;
      }

        Map<Character, Integer> charMap = new HashMap<>();
        char[] vowelArr = {'a','e','i','o','u'};
        for(char ch: vowelArr){
            charMap.put(ch,0);
        }


        return 0;
    }
}
