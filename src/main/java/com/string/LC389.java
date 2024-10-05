package com.string;

public class LC389 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        char ch = findTheDifference(s,t);
        System.out.println(ch);

    }

    public static char findTheDifference(String s, String t) {
       char[] arr = new char[26];

       for(int i=0;i<t.length();i++){
           arr[t.charAt(i)-'a']++;
       }

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']--;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return (char) (97+i);
            }
        }

        return ' ';
    }
}
