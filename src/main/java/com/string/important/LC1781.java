package com.string.important;

public class LC1781 {

    public static void main(String[] args) {
        String s = "aabcb";
        LC1781 lc  = new LC1781();
        int count = lc.beautySum(s);
        System.out.println(count);
    }

    public int beautySum(String s) {
       int count = 0;

       for(int i=0;i<s.length();i++){
           int[] freq = new int[26];
           for(int j=i;j<s.length();j++){
               freq[s.charAt(j)-'a']++;
               int maxFrequency = 0;
               int minFrequency = 10000;
               for(int f: freq){
                   if(f>0) {
                       maxFrequency = Integer.max(maxFrequency, f);
                       minFrequency = Integer.min(minFrequency, f);
                   }
               }
               count+=(maxFrequency-minFrequency);
           }
       }
       return count;
    }
}
