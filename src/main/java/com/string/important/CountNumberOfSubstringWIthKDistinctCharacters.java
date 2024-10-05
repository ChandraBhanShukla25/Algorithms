package com.string.important;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubstringWIthKDistinctCharacters {

    public static void main(String[] args) {
        String s= "cdad";
        int k =4;
        CountNumberOfSubstringWIthKDistinctCharacters count = new CountNumberOfSubstringWIthKDistinctCharacters();
        long x = count.substrCount(s,k);
        System.out.println(x);
    }

    long substrCount (String s, int k) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        if(s.length()==k){
            return 1;
        }
        long count =  substr(s, k) - substr(s, k-1);
        return count;
    }

     long substr(String s, int k) {
        int count = 0;
        int i=0;
        int j=0;
        Map<Character,Integer> charMap = new HashMap<>();
        while(i<s.length()){
            charMap.merge(s.charAt(i),1,Integer::sum);
            while(charMap.size()>k){
                charMap.merge(s.charAt(j), -1, Integer::sum);
                if(charMap.get(s.charAt(j))==0){
                    charMap.remove(s.charAt(j));
                }
                j++;
            }
            count+= i-j+1;
            i++;
        }
        return count;
    }


}
