package com.revision.string;

import java.util.*;

public class LC451 {

    public static void main(String[] args) {
        String str = "cccaaa";
        String res = frequencySort(str);
        System.out.println(res);
    }

    public static  String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch: s.toCharArray()){
            frequencyMap.merge(ch, 1, Integer::sum);
        }
        LinkedList<Map.Entry<Character,Integer>> lst = new LinkedList<>(frequencyMap.entrySet());

        Collections.sort(lst, new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character,Integer> entry: lst){
            Character key = entry.getKey();
            Integer val = entry.getValue();
            while(val!=0){
                res.append(key);
                val--;
            }

        }

        return res.reverse().toString();
    }
}
