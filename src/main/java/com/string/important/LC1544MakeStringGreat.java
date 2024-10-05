package com.string.important;

import java.util.Stack;

public class LC1544MakeStringGreat {

    public static void main(String[] args) {
        String s = "leEeetcode";
        LC1544MakeStringGreat makeStringGreat = new LC1544MakeStringGreat();
        String result = makeStringGreat.makeGood(s);
        System.out.println(result);
    }

    public String makeGood(String s) {
        if (s.isEmpty())
            return s;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && (s.charAt(i) - 32 == stack.peek() || stack.peek() - 32 == s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}
