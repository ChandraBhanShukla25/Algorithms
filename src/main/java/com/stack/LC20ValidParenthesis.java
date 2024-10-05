package com.stack;

import java.util.Map;
import java.util.Stack;

public class LC20ValidParenthesis {


    public boolean isValid(String s) {
        Map<Character,Character> map = Map.of('{','}','(',')','[',']');
        Stack<Character> stack = new Stack<>();
       for(int i=0;i<s.length();i++){
           if(map.containsKey(s.charAt(i))){
               stack.push(s.charAt(i));
           }else{
               if(stack.isEmpty())
                   return false;
               char ch = stack.peek();
               if(map.get(ch)!=s.charAt(i)){
                   return false;
               }
               stack.pop();
           }
       }
       if(!stack.isEmpty())
           return false;
       return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        LC20ValidParenthesis validParenthesis = new LC20ValidParenthesis();
        boolean isValid = validParenthesis.isValid(s);
        System.out.println(isValid);
    }
}
