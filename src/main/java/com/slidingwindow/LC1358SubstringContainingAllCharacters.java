package com.slidingwindow;

import java.util.Arrays;

public class LC1358SubstringContainingAllCharacters {

    public static void main(String[] args) {
       String str = "abcabc";
       LC1358SubstringContainingAllCharacters substringContainingAllCharacters = new LC1358SubstringContainingAllCharacters();
       int count = substringContainingAllCharacters.numberOfSubstrings(str);
        int count1 = substringContainingAllCharacters.numberOfSubstringsOptimized(str);
        System.out.println(count);
        System.out.println(count1);
    }
    public int numberOfSubstrings(String s) {
       int count = 0;
       for(int i=0;i<s.length();i++){
           int[] hash = new int[3];
           for(int j=i;j<s.length();j++){
               hash[s.charAt(j)-'a']=1;
               if(hash[0]==1 && hash[1]==1 && hash[2]==1){
                   count+=1;
               }
           }

       }
       return count;
    }

    public int numberOfSubstringsOptimized(String s) {
        int count = 0;
        int[] hash = new int[3];
        Arrays.fill(hash, -1);
        for(int i=0;i<s.length();i++){
          hash[s.charAt(i)-'a']=i;
          if(hash[0]!=-1 && hash[1]!=-1  && hash[2]!=-1 ) {
              count += (1 + Integer.min(hash[0], Integer.min(hash[1], hash[2])));
          }
        }
        return count;
    }
}
