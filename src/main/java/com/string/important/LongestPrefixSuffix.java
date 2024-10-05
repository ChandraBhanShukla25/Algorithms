package com.string.important;

public class LongestPrefixSuffix {

        int lps(String s) {
            int prefix = 0;
            int suffix = 1;
            int[] lps = new int[s.length()];
            while(suffix<s.length()){
                if(s.charAt(prefix)==s.charAt(suffix)){
                    lps[suffix]=prefix+1;
                    prefix=prefix+1;
                    suffix=suffix+1;
                }else{
                    if(prefix==0){
                        suffix=suffix+1;
                    }else{
                        prefix=lps[prefix-1];
                    }
                }
            }
            return lps[s.length()-1];
        }

    public static void main(String[] args) {
        LongestPrefixSuffix longestPrefixSuffix = new LongestPrefixSuffix();
        int x =0;
        x=longestPrefixSuffix.lps("ABCSASABCSAB");
        System.out.println(x);
    }

}
