package com.string;

public class LPSLC5 {

    public String longestPalindrome(String s) {
       int[][] dp = new int[s.length()+1][s.length()+1];
       String s1 = new StringBuilder().append(s).reverse().toString();
       StringBuilder sb = new StringBuilder();
       StringBuilder largestStr = new StringBuilder();
       for(int i=0;i<s.length();i++){
               if( s.charAt(i)==s1.charAt(i)){
                   sb.append(s.charAt(i));
                   if(sb.length()>largestStr.length()){
                       largestStr=sb;
                   }
               }else{
                   sb = new StringBuilder();
               }
       }
        System.out.println(largestStr);
       return largestStr.toString();
    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = "a";
        LPSLC5 lps = new LPSLC5();
        System.out.println(lps.longestPalindrome(s1));
    }
}
