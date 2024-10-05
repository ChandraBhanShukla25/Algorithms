package com.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class LC1048LongestStringChain {

    public static void main(String[] args) {
       String[] words = {"a","b","ba","bca","bda","bdca"};
       LC1048LongestStringChain longestStringChain = new LC1048LongestStringChain();
       int x = longestStringChain.longestStrChain(words);
        System.out.println(x);
    }

    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
    public int longestStrChain(String[] words) {
        int dp[] = new int[words.length];
        Arrays.sort(words,comp);
        Arrays.fill(dp,1);
        for(int i=1;i<words.length;i++){
            for(int j =0;j<i;j++){
                if(isChain(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }

        int maxi = 0;
        for(int i=0;i<dp.length;i++){
            maxi = Integer.max(dp[i],maxi);
        }
      return maxi;
    }

    public boolean isChain(String s1, String s2){
       int first=0;
       int second = 0;
       while(first<s1.length()){
           if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
               first++;
               second++;
           }else{
               first++;
           }
       }
       return first==s1.length() && second==s2.length();
    }
}
