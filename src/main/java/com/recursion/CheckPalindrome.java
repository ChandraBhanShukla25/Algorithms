package com.recursion;

public class CheckPalindrome {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        CheckPalindrome checkPalindrome = new CheckPalindrome();
        System.out.println(checkPalindrome.isPalindrome(str));
        System.out.println(checkPalindrome.isPalindrome("race a car"));
        System.out.println(checkPalindrome.isPalindrome("0P"));


    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)>='a' && s.charAt(i)<='z'){
               sb.append(s.charAt(i));
           } else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
               sb.append((char) (s.charAt(i)+('a'-'A')));
           }
       }
       return checkPalindrome(sb.toString(), 0);
    }

    private boolean checkPalindrome(String s, int i) {
        if(i>=s.length()-i-1){
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-1-i))
            return false;
        return checkPalindrome(s,i+1);
    }
}
