package com.numbers;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V", 5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int x = 0;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && map.containsKey(s.charAt(i) +String.valueOf(s.charAt(i+1)))){
                x+=map.get(s.charAt(i) +String.valueOf(s.charAt(i+1)));
                i++;
            }else if(map.containsKey(String.valueOf(s.charAt(i)))){
                x+=map.get(String.valueOf(s.charAt(i)));
            }
        }
        return x;
    }

    public static void main(String[] args) {
       String s = "MCMXCIV";
       RomanToInteger13 roman = new RomanToInteger13();
       int x = roman.romanToInt(s);
       System.out.println(x);
    }
}
