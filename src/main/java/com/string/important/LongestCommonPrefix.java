package com.string.important;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String str = "ABCDEABDABCDABCDEFD";
        String prefix = longestPrefix(str);
        System.out.println(prefix);
    }

    public static  String longestPrefix(String str){
        String prefix = "";
        int k=0;
           for(int j=0;j<str.length();j++){
               if(j!=k && str.charAt(k)==str.charAt(j)){
                   prefix= str.substring(0,k+1).length()> prefix.length()? str.substring(0,k+1): prefix;
                   k++;
               }else {
                   k=0;
               }
           }
        return prefix;
    }
}
