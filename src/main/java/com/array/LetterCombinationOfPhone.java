package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhone {

    static Map<Character, String> map = new HashMap<>();


    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
       String s = "47";
       List<String> lst = letterCombination(s);
        System.out.println(lst);
    }

    private static List<String> letterCombination(String s) {
        if(s==null || s.isEmpty()) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        recursivelyGetLetters(s, result, 0, new StringBuilder());
        return result;
    }

    private static void recursivelyGetLetters(String s, List<String> result, int idx, StringBuilder current) {
        if(idx==s.length()){
            result.add(current.toString());
            return;
        }

        String letters = map.get(s.charAt(idx));

        for(char ch: letters.toCharArray()){
            current.append(ch);
            recursivelyGetLetters(s, result, idx+1, current);
            current.deleteCharAt(current.length()-1);
        }
    }

}

