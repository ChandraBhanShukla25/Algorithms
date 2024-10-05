package com.string.important;

import java.util.Arrays;

public class LC796RotateString {

    public static void main(String[] args) {
        LC796RotateString rotateString = new LC796RotateString();
        String s = "abcde"; String goal = "abced";
        boolean isRotated = rotateString.rotateString(s,goal);
        System.out.println(isRotated);
    }


    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int j=0;
        int i=0;
       for( i=0;i<s.length();i++){
           if(s.charAt(i)==goal.charAt(j)){
               break;
           }
       }

       while(i<s.length() && j<goal.length()){
           if(s.charAt(i)!=goal.charAt(j)){
               return false;
           }
           i++;
           j++;
       }
       int x=0;
       while(x<i-j-1){
           if(s.charAt(x)!=goal.charAt(j)){
               return false;
           }
           x++;
           j++;
       }
       return true;

    }
}
