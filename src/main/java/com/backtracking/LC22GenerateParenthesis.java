package com.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC22GenerateParenthesis {

    public static void main(String[] args) {
        int n =3;
        LC22GenerateParenthesis lc22GenerateParenthesis = new LC22GenerateParenthesis();
        lc22GenerateParenthesis.generateParenthesis(n);
    }

    public List<String> generateParenthesis(int n){
        char arr[] = new char[n*2];
        for(int i=0;i<n;i++){
            arr[i]= '(';
        }
        for(int i=n;i<arr.length;i++){
            arr[i]=')';
        }
        List<String> list = new ArrayList<>();
        generateParenthesis(arr, 0, list);
        System.out.println(list);
        return list;
    }

    public void generateParenthesis(char[] arr, int n, List<String> list) {
        if(n==arr.length){
            if(isValid(arr) && !list.contains(new String(arr))){
                list.add(new String(arr));
            }
            return;
        }
        for(int i=n;i<arr.length;i++){
            swap(arr, i, n);
            generateParenthesis(arr, n+1, list);
            swap(arr, i, n);
        }
    }

    private boolean isValid(char[] arr) {
        Stack<Character> stack = new Stack<>();
        for(char ch: arr){
            if(ch=='('){
                stack.push(ch);
            } else{
                if(stack.isEmpty()){
                    return false;
                } else{
                    stack.pop();
                }
            }
        }
        return true;
    }

    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
