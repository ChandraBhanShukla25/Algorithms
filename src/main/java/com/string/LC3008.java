package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC3008 {
    int PRIME = 11;

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
       List<Integer> indexesForPatA = search(s,a);
       List<Integer> indexesForPatB = search(s,b);
       List<Integer> beautifulIndexes = new ArrayList<>();
       for(int i=0;i<indexesForPatA.size();i++){
           for(int j=0;j<indexesForPatB.size();j++){
               if(Math.abs(indexesForPatA.get(i)-indexesForPatB.get(j))<=k){
                   if(indexesForPatA.get(i)>indexesForPatB.get(j)){
                       beautifulIndexes.add(indexesForPatB.get(j));
                       beautifulIndexes.add(indexesForPatA.get(i));
                   }else {
                       beautifulIndexes.add(indexesForPatA.get(i));
                       beautifulIndexes.add(indexesForPatB.get(j));
                   }
               }
           }
       }
       if(beautifulIndexes.isEmpty()){
           return Arrays.asList(0);
       }else {
           return beautifulIndexes;
       }
    }


    public List<Integer> search(String txt, String pattern){
        List<Integer> indexes = new ArrayList<>();
        int txtLength = txt.length();
        int patLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double currentTxtHash = calculateHash(txt.substring(0,patLength));
        for(int i=0;i<=txtLength-patLength;i++){
            if(currentTxtHash==patternHash){
                if(txt.substring(i,patLength+i).equals(pattern)){
                    indexes.add(i);
                }
            }
            if(i<txtLength-patLength){
                currentTxtHash= updateHash(txt.charAt(i),txt.charAt(i+patLength),patLength,currentTxtHash);
            }
        }
        return indexes;
    }

    public double calculateHash(String pattern){
        double hash = 0.0;
        for(int i=0;i<pattern.length();i++){
            hash+=pattern.charAt(i)*Math.pow(PRIME,i);
        }
        return hash;
    }

    public double updateHash(char prevChar, char currentChar, int patternLength, double currentHash){
        double hash = (currentHash-prevChar)/PRIME;
        hash+= currentChar*Math.pow(PRIME,patternLength-1);
        return hash;
    }

    public static void main(String[] args) {
       String s = "isawsquirrelnearmysquirrelhouseohmy";
       String a = "my";
       String b = "squirrel";
       int k = 15;
       LC3008 lc3008 = new LC3008();
       List<Integer> lst = lc3008.beautifulIndices(s,a,b,k);
        System.out.println(lst);
    }
}
