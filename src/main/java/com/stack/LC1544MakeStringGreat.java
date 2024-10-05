package com.stack;

import java.util.Stack;

public class LC1544MakeStringGreat {

    public static void main(String[] args) {
     String s = "leEeetcode";
     LC1544MakeStringGreat makeStringGreat = new LC1544MakeStringGreat();
     String str = makeStringGreat.makeGood(s);
        System.out.println(str);
    }

    public String makeGood(String s) {
        if(s.isEmpty())
            return "";
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char c: arr){
           if(!st.isEmpty()){
               char ch = st.peek();
               int x = 'a'-'A';
               if(c+x == ch || c-x==ch){
                   st.pop();
               }else{
                   st.push(c);
               }
           }else{
               st.push(c);
           }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        if(sb.length()!=0) {
            sb.reverse();
        }
        return  sb.toString();
    }
}
