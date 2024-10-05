package com.string.important;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgo {

    int PRIME = 11;
    public static void main(String[] args) {
        String str = "isawsquirrelnearmysquirrelhouseohmy";
        String pattern = "squirrel";
        String pattern1 = "my";
        RabinKarpAlgo rabinKarpAlgo = new RabinKarpAlgo();
        List<Integer> idx = rabinKarpAlgo.search(str, pattern);
        List<Integer> idx1 = rabinKarpAlgo.search(str, pattern1);
        System.out.println(idx);
        System.out.println(idx1);
    }


    public List<Integer> search(String text, String pattern){
        List<Integer> indexes = new ArrayList<>();
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));

        for(int i=0; i<= text.length() - patternLength; i++) {
            if(textHash == patternHash) {
                if(text.substring(i, i+patternLength).equals(pattern)) {
                    indexes.add(i);
                }
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
        return indexes;
    }

    private double calculateHash(String str) {
        double hash = 0;
        for(int i=0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }
}
