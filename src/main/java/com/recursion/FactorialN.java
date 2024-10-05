package com.recursion;

public class FactorialN {


    public static void main(String[] args) {
        int n =5;
        System.out.println(fact(n));
    }

    private static int fact(int n) {
        if(n<=1){
            return 1;
        }
        int y = Integer.MAX_VALUE;
        y =  n*fact(n-1);
        return y;
    }
}
