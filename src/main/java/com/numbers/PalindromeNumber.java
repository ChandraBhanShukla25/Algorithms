package com.numbers;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int k = x;
        int y = 0;
        return x==palindromeNum(k, y);
    }

    public int palindromeNum(int x, int y){
        if(x==0){
            return y;
        }
        y= y*10 + x%10;
        return palindromeNum(x/10, y);
    }

    public static void main(String[] args) {
        int x = 121;
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(x));
    }
}
