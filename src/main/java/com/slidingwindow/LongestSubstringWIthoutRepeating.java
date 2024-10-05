package com.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWIthoutRepeating {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = new LongestSubstringWIthoutRepeating().lengthOfLongestSubstring(str);
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int j=0;
        int maxLength = Integer.MIN_VALUE;
        for(int i=0; i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            maxLength=Integer.max(i-j, maxLength);
            set.add(s.charAt(i));
        }
        return maxLength;
    }
}
