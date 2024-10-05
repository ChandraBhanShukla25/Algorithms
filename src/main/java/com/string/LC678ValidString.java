package com.string;

import java.util.SortedMap;
import java.util.Stack;

public class LC678ValidString {

    public static void main(String[] args) {
        String  s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        LC678ValidString validString = new LC678ValidString();
        boolean isValid = validString.checkValidString(s);
        System.out.println(isValid);
    }

    public boolean checkValidString(String s) {
        int openBracket = 0;
        int closeBracket = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                openBracket++;
            }else{
                openBracket--;
            }

            if(s.charAt(s.length()-1-i)==')' || s.charAt(s.length()-1-i)=='*'){
                closeBracket++;
            }else{
                closeBracket--;
            }

            if(openBracket<0 || closeBracket<0){
                return false;
            }
        }
        return true;
    }
}
