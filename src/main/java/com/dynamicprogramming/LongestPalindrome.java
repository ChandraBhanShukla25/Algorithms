package com.dynamicprogramming;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s1 = "AABDCA";
        String s2 = new StringBuilder(s1).reverse().toString();
        int dp[][] = new int[s1.length()+1][s1.length()+1];

        StringBuilder longestStr = new StringBuilder();
        StringBuilder currentStr = new StringBuilder();

        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1)==s2.charAt(i-1)){
                currentStr.append(s1.charAt(i-1));
            }else{
                longestStr = longestStr.length()>currentStr.length()? new StringBuilder(longestStr): new StringBuilder(currentStr);
                currentStr=new StringBuilder();
            }
        }
        longestStr = longestStr.length()>currentStr.length()? new StringBuilder(longestStr): new StringBuilder(currentStr);

        System.out.println(longestStr.toString());
    }
}
