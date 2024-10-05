package com.string;

import java.util.*;

public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramsMap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sortedStr = String.valueOf(str);
            if(anagramsMap.containsKey(sortedStr)){
                 anagramsMap.get(sortedStr).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                anagramsMap.put(sortedStr, list);
            }
        }
        List<List<String>> lst = new ArrayList<>();
        for(String key: anagramsMap.keySet()){
            lst.add(anagramsMap.get(key));
        }
        return lst;
    }

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>>  strlist = groupAnagrams.groupAnagrams(str);
        System.out.println(strlist);
    }
}
