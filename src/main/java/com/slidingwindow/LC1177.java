package com.slidingwindow;

import java.util.*;

public class LC1177 {

    public static void main(String[] args) {
        String s = "hunu";
        int[][] queries = {{0,3,1},{1,1,1}};
        LC1177 lc1177 = new LC1177();
        List<Boolean> lst = lc1177.canMakePaliQueries(s,queries);
        System.out.println(lst);
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
         List<Boolean> lst = new ArrayList<>(queries.length);

         for(int i=0;i<queries.length;i++){
             String substr = s.substring(queries[i][0],queries[i][1]+1);
             if(isPalindrome(substr, queries[i][2])){
                 lst.add(true);
             }else{
                 lst.add(false);
             }
         }
         return lst;
    }

    public boolean isPalindrome(String str, int count){
        String s2 = new StringBuilder(str).reverse().toString();
        str = rearrange(str);
        if(str.equals(s2)){
            return true;
        } else if(count>0){
            int mismatch =0;
            for(int i=0;i<str.length()/2;i++){
                if(str.charAt(i)!=str.charAt(str.length()-i-1))
                    mismatch++;
            }

            if(mismatch<=count){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private String rearrange(String str) {
        Map<Character, Integer> map = new HashMap();

        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
        }

        char[] arr = new char[str.length()];

        Set<Character> set = map.keySet();
        int i=0;
        int j=str.length()-1;
        for(char ch: set){
            int count = map.get(ch);
            if(count>1){
                while(count!=0){
                    arr[i]=ch;
                    count--;
                    i++;
                    arr[j]=ch;
                    count--;
                    j--;
                }
            }else{
                arr[i]=ch;
            }
        }
        return new String(arr);
    }
}
