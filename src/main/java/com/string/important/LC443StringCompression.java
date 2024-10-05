package com.string.important;

public class LC443StringCompression {

    public static void main(String[] args) {
        char arr[] = {'a','a','b','b','c','c','c'};
        LC443StringCompression stringCompression = new LC443StringCompression();
        int x = stringCompression.compress(arr);
        System.out.println(x);
    }

    /*
       a
     */

    public int compress(char[] chars) {

       int index = 0;

       int i=0;
       int n = chars.length;
       if(chars.length==0){
           return 0;
       }

       while(i<n){
           char currentChar = chars[i];
           int count = 0;
           while(i<n && currentChar==chars[i]){
               count++;
               i++;
           }
           chars[index]=currentChar;
           index++;
           if(count>1){
               String str = String.valueOf(count);
               int j=0;
               while(j<str.length()){
                   chars[index] = str.charAt(j);
                   index++;
                   j++;
               }
           }
       }
       return index;
    }

}
