package com.stack;

import java.util.Stack;

public class LC1249 {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    sb.setCharAt(i, '#');
                }
            }
        }

        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(),'#');
        }
        return sb.toString().replace("#","");
    }

    public static void main(String[] args) {
        String s = "a)b(c)d";
        LC1249 lc1249 = new LC1249();
        String str = lc1249.minRemoveToMakeValid(s);
        System.out.println(str);
    }
}
