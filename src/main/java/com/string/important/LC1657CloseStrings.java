package com.string.important;

import java.util.Arrays;

public class LC1657CloseStrings {

    public static void main(String[] args) {
        LC1657CloseStrings closeStrings = new LC1657CloseStrings();
        String word1 = "uau"; String word2 = "ssx";
        boolean isClose = closeStrings.closeStrings(word1,word2);
        System.out.println(isClose);
    }

    public boolean closeStrings(String word1, String word2) {
         int arr1[] = new int[26];
         int arr2[] = new int[26];
         Arrays.fill(arr1,0);
         Arrays.fill(arr2,0);
        if(word1.length()!=word2.length())
            return false;
         for(int i=0;i<word1.length();i++){
             arr1[word1.charAt(i)-'a']++;
         }
        for(int i=0;i<word2.length();i++){
            arr2[word2.charAt(i)-'a']++;
        }


        for(int i=0;i<arr1.length;i++){
           if(arr1[i]==0 && arr2[i]!=0){
               return false;
           }
           if(arr2[i]!=0 && arr1[i]==0)
               return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
