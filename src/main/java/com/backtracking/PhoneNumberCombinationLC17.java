package com.backtracking;

import javax.naming.ldap.SortResponseControl;
import java.util.*;

public class PhoneNumberCombinationLC17 {

    static Map<String, List<Character>> numberMap = new HashMap<>();
    static String[] digitToLetters = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        printCombinations(sb, digits, index, result);
        System.out.println(result);
        return result;
    }

    public void printCombinations(StringBuilder sb, String digits, int index, List<String> result){
        if(sb.length()==digits.length()){
            result.add(new String(sb));
        }else{
            String str = digitToLetters[digits.charAt(index)-'0'];
            for(char ch: str.toCharArray()){
               printCombinations(sb.append(ch), digits, index+1, result);
               sb.deleteCharAt(sb.length()-1);
            }
        }
    }


    public static void main(String[] args) {
       String digits = "23";
       PhoneNumberCombinationLC17 lc17 = new PhoneNumberCombinationLC17();
       lc17.letterCombinations(digits);
    }
}
