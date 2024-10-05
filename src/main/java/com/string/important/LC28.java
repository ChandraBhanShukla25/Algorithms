package com.string.important;

public class LC28 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "c";
        LC28 lc28= new LC28();
        int x =lc28.strStr(s1,s2);
        System.out.println(x);
    }

    public int strStr(String s1, String s2){
        if(s1.isEmpty() || s2.isEmpty()){
            return -1;
        }
        int[] lps = findLps(s2);

        int i = 0;
        int j = 0;

        while(j<s2.length() && i<s1.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                if(j==0){
                    i++;
                }else{
                    j=lps[j-1];
                }
            }
        }
        if(j==s2.length()){
            return i-j;
        }
        return -1;
    }

    public int[] findLps(String s){
        int[] lps = new int[s.length()];
        int prefix = 0;
        int suffix = 1;

        while(suffix<s.length()){
            if(s.charAt(prefix)==s.charAt(suffix)){
                lps[suffix]=prefix+1;
                suffix=suffix+1;
                prefix=prefix+1;
            }else{
                if(prefix==0){
                    lps[suffix]=0;
                    suffix=suffix+1;
                }else{
                    prefix=lps[prefix-1];
                }
            }
        }
        return lps;
    }
}
