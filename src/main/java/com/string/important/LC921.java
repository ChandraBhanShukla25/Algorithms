package com.string.important;

import java.util.Stack;

public class LC921 {

    public static void main(String[] args) {
        String str = ")())";
       LC921 lc921 = new LC921();
       int count = lc921.minAddToMakeValid(str);
        System.out.println(count);
    }

    public int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
       for(int i=0;i<s.length();i++){
           if(stack.isEmpty() && s.charAt(i)==')'){
               count++;
           }else if(s.charAt(i)=='('){
               stack.push('(');
           }else if(s.charAt(i)==')'){
               stack.pop();
           }
       }
       return count+stack.size();
    }
}
