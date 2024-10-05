package com.string;

public class IndexOfFirstOccurrence {
    int PRIME=3;
    public static void main(String[] args) {
        String str = "gffgfg";
        String pattern = "gfg";
        IndexOfFirstOccurrence indexOfFirstOccurrence = new IndexOfFirstOccurrence();
        int idx = indexOfFirstOccurrence.findMatching(str,pattern);
        System.out.println(idx);
    }

    public int findMatching(String text, String pat) {
        double patternHash = calculateHash(pat);
        double textHash = calculateHash(text.substring(0,pat.length()));
        for(int i=0;i<=text.length()-pat.length();i++){
            if(textHash==patternHash){
                if(text.substring(i,pat.length()+i).equals(pat)){
                    return i;
                }
            }

            if(i<text.length()-pat.length()){
                textHash=updateHash(textHash, text.charAt(i+pat.length()), text.charAt(i), pat.length());
            }
        }
        return -1;

    }

    public double calculateHash(String str){
        double hash = 0.0;
        for(int i=0;i<str.length();i++){
            hash+= str.charAt(i)*Math.pow(PRIME,i);
        }
        return hash;
    }

    public double updateHash(double prevHash, char currentChar, char prevChar, int patternLength){
        prevHash = (prevHash-prevChar)/PRIME;
        double newHash = prevHash+ currentChar*Math.pow(PRIME,patternLength-1);
        return newHash;
    }
}
