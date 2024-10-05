package com.string.important;

public class LC1021 {

    public static void main(String[] args) {
       String s = "(()())(())";
       LC1021 removeParenthesis = new LC1021();
       String str = removeParenthesis.removeOuterParentheses(s);
       System.out.println(str);
    }

    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();

        int outerParenthesis = 0;
        if(s.isEmpty())
            return "";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(outerParenthesis>0){
                    sb.append("(");
                }
                outerParenthesis++;
            }
            else {
                outerParenthesis--;
                if(outerParenthesis>0){
                    sb.append(")");
                }
            }
        }
        return sb.toString();

    }
}
