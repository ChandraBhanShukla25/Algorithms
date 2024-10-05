package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFIx {

    public static void main(String[] args) {
        String input = "(p+q)*(m-n)";

        InfixToPostFIx infixToPostFIx = new InfixToPostFIx();
       String str =  infixToPostFIx.infixToPostFix(input);
        System.out.println(str);

    }

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public String infixToPostFix(String input){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch: input.toCharArray()){

            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch== ')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                    while(!stack.isEmpty() && Prec(stack.peek())>Prec(ch)){
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                }

        }

        while(!stack.isEmpty()){
            if(stack.peek()=='(' ){
               return "Invalid Expression";
            }
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
