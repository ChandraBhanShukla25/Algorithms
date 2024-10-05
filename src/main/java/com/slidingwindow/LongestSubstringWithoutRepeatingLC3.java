package com.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingLC3 {

    public static void main(String[] args) {
        String s= "abcabcbb";
        String s1 = "bbbbb";

        int length = longestSubstr(s);
        int length1 = longestSubstr(s1);
        System.out.println(length);
        System.out.println(length1);
    }

    private static int longestSubstr(String s) {
        int i=0; int j=0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        String str = "";
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                while(s.charAt(j)!=s.charAt(i)){
                    set.remove(s.charAt(j));
                    j++;
                }
                j= j+1;
                set.add(s.charAt(i));
            }
            if(i-j+1> maxLength){
                str = s.substring(j, i+1);
            }
            maxLength = Integer.max(maxLength, i-j+1);
            i++;
        }
        System.out.println(str);
        return maxLength;
    }
}
