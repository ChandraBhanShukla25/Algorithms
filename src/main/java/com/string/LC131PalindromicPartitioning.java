package com.string;

import java.util.ArrayList;
import java.util.List;

public class LC131PalindromicPartitioning {

    public static void main(String[] args) {
        String s = "aab";
        LC131PalindromicPartitioning lc31 = new LC131PalindromicPartitioning();
        List<List<String>> lst = lc31.partition(s);
        System.out.println(lst);
    }

    private List<List<String>> partition(String s) {
        List<String> result = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        calculatePalindromes(s, 0, result, list);
        return list;
    }

    private void calculatePalindromes(String s, int index, List<String> result, List<List<String>> list) {

        if(index==s.length()){
            list.add(new ArrayList<>(result));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                result.add(s.substring(index,i+1));
                calculatePalindromes(s,i+1,result,list);
                result.remove(result.size()-1);
            }
        }

    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
