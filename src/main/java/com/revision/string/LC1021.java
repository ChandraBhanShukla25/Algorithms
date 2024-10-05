package com.revision.string;

public class LC1021 {


        public static void main(String[] args) {
            String s = "(()())(())(()(()))";
            String res = removeOuterParentheses(s);
            System.out.println(res);
        }

        public static String removeOuterParentheses(String s) {
            int openCount = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    if(openCount>0){
                        sb.append(s.charAt(i));
                    }
                    openCount++;
                }else{
                    if(openCount>1){
                        sb.append(s.charAt(i));
                    }
                    openCount--;
                }
            }
            return sb.toString();
        }
    }

