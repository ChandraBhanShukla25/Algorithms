package com.backtracking;

import java.util.*;

public class LC139WordBreak {

    public static void main(String[] args) {
        String s= s = "leetcode";
        String [] wordDict = {"leet","code"};
        List<String> strList = Arrays.asList(wordDict);
        LC139WordBreak wordBreakSol = new LC139WordBreak();
        boolean isWrod = wordBreakSol.wordBreak(s, strList);
        System.out.println(isWrod);

    }

    public boolean wordBreak(String s, List<String> wordDict) {
       boolean[] dp = new boolean[s.length()+1];
       Set<String> set = new HashSet<>(wordDict);
       dp[0]=true;

       for(int i=1; i<=s.length(); i++){
           for(int j=0;j<i;j++){
               if(dp[j] && set.contains(s.substring(j,i))){
                   dp[i] = true;
               }
           }
       }
       return dp[s.length()];
    }
}
