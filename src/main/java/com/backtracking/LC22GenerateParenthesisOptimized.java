package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParenthesisOptimized {

    public static void main(String[] args) {
        int n =3;
        LC22GenerateParenthesisOptimized generateParenthesis = new LC22GenerateParenthesisOptimized();
        generateParenthesis.generateParenthesis(n);
    }

    public List<String> generateParenthesis(int n) {
        int openCount = 0;
        int closeCount =0;
        List<String> result= new ArrayList<>();
        String str = "";
        generateParenthesisResult(openCount,closeCount, n, str, result);
        System.out.println(result);
        return result;
    }

    private void generateParenthesisResult(int openCount, int closeCount, int n, String str, List<String> result) {
        if(openCount>n || closeCount>n || openCount<closeCount){
            return;
        }
        if(openCount==closeCount && openCount==n){
            result.add(str);
            return;
        }
        generateParenthesisResult(openCount+1,closeCount,n, str + "(",  result);
        generateParenthesisResult(openCount,closeCount+1,n,str+ ")", result );
    }
}
