package com.dynamicprogramming;

public class DPFibonacciOptimal {

    public static void main(String[] args) {
        int n =6;
        DPFibonacciOptimal fibonacciRecursion = new DPFibonacciOptimal();
        int x =fibonacciRecursion.fibonacciRecursion(n);
        System.out.println(x);
    }

    private int fibonacciRecursion(int n) {
        int prev = 1;
        int prev_prev = 0;

        for(int i=2;i<=n;i++){
           int curr = prev_prev+prev;
           prev_prev =prev;
           prev=curr;
        }
        return prev;
    }
}
