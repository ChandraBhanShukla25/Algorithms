package com.string;

public class LC214ShortestPalindrome {

    public static void main(String[] args) {
        LC214ShortestPalindrome shortestPalindrome = new LC214ShortestPalindrome();
        String s= "abcd";
        String str = shortestPalindrome.shortestPalindrome(s);
        System.out.println(str);
    }

    public String shortestPalindrome(String s) {
       int base =131;
       long multiplier = 1;
       long suffix = 0;
       long prefix =0;
       long mod = (long) 1e9+7;
       int palindromeIdx = 0;

       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           int charVal = ch-'a'+1;
           prefix = (prefix*base + charVal)%mod;
           suffix = (suffix + (charVal*multiplier))%mod;
           multiplier = (multiplier*base)%mod;
           if(prefix==suffix){
               palindromeIdx = i+1;
           }
       }

        if(palindromeIdx==s.length()){
            return s;
        }

        // to make the string a palindrome
        String suffixToBeAdded = new StringBuilder(s.substring(palindromeIdx)).reverse().toString();
        return suffixToBeAdded +s;



    }
}
