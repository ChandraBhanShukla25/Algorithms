package com.recursion;

public class PrintNNumbers {


    public static void main(String[] args) {
        int n = 5;
        int i = 1;
        printNDesc(n, i);
    }

    private static void printNDesc(int n, int i) {
        if(i>n){
            return;
        }
        printNDesc(n,i+1);
        System.out.println(i);
    }
}
