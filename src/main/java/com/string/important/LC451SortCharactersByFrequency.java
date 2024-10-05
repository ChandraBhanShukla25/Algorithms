package com.string.important;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class LC451SortCharactersByFrequency {

    public static void main(String[] args) {
      String s= "tree";
      frequencySort(s);
    }

    public static String frequencySort(String s) {
        if(s.isEmpty())
            return "";
        HashMap<Character, Integer> map =  new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.merge(s.charAt(i),1, Integer::sum);
        }
        LinkedList<Map.Entry<Character,Integer>> lst = new LinkedList<>(map.entrySet());
        Collections.sort(lst, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry: lst){
            char ch = entry.getKey();
            int count = entry.getValue();
            while(count>0){
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }
}
