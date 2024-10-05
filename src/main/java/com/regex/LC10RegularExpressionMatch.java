package com.regex;

public class LC10RegularExpressionMatch {

    public static void main(String[] args) {
       String s = "aa";
       String p = "a";
       LC10RegularExpressionMatch expressionMatch = new LC10RegularExpressionMatch();
       boolean flag = expressionMatch.isMatch(s,p);
        System.out.println(flag);
    }

    public boolean isMatch(String s, String p) {
        for(int i=0;i<s.length();i++){
            if(i<p.length() && s.charAt(i)==p.charAt(i))
                continue;
            else if(i<p.length() && s.charAt(i)!=p.charAt(i) && p.charAt(i)=='.')
                continue;
            else if(i<p.length() && s.charAt(i)!=p.charAt(i) && i==p.length()-1 && p.charAt(i)=='*'){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
}
