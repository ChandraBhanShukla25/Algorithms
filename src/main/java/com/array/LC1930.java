package com.array;

import java.util.HashSet;
import java.util.Set;

public class LC1930 {

    public static void main(String[] args) {
       String s= "adc";
       int x  = countPalindromicSubsequence(s);
       System.out.println(x);
    }

    public static int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
       for(char ch='a';ch<='z';ch++){
           int firstIndex = s.indexOf(ch);
           int lastIndex = s.lastIndexOf(ch);
            if(firstIndex<lastIndex){
                for(int i=firstIndex+1;i<lastIndex;i++){
                    String str = ""+ ch+s.charAt(i)+ch;
                    set.add(str);
                }
            }
       }
       return set.size();
    }
}
