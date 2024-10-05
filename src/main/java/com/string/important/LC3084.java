package com.string.important;

public class LC3084 {

    public long countSubstrings(String s, char c) {
       long count = s.chars().filter(a-> a==c).count();
       long countOfStrs = count+(count*(count-1)/2);
       return countOfStrs;
    }



    public static void main(String[] args) {
        String s = "abada";
        char c = 'a';
        LC3084 lc3084 = new LC3084();
        long count = lc3084.countSubstrings(s,c);
        System.out.println(count);
    }
}
