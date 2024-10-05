package com.slidingwindow;

import java.util.*;

public class LongestRepeatingCharacterReplacementLC424 {

//NOt done
    public int characterReplacement(String s, int k) {

        int i=0;
        int j=0;
        int count=0;
        Map<Character,Integer> map = new HashMap<>();
        while(i<s.length()){
            map.merge(s.charAt(i), 1, Integer::sum);

        }
        return  0;
    }

    public static void main(String[] args) {
        String s1 = "AABABBA";
        int k1 = 1;

        String s2 = "ABAB";
        int k2 = 2;

        LongestRepeatingCharacterReplacementLC424 replacementLC424 = new LongestRepeatingCharacterReplacementLC424();
        int x1 = replacementLC424.characterReplacement(s1,k1);
        int x2 = replacementLC424.characterReplacement(s2,k2);

        System.out.println(x1);
        System.out.println(x2);
    }
}
