package com.dynamicprogramming;

public class PrintLCSDP {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";
       // String s = lcsString(s1,s2,s1.length()-1,s2.length()-1, "");
        //System.out.println(s);
    }

    public String lcsString(String s1, String s2, int m, int n){
        if(m<0 || n<0){
            return "";
        }
        String res = "";
        if(s1.charAt(m)==s2.charAt(n)){
            res= s1.charAt(m)+lcsString(s1,s2,m-1,n-1);
        }

        return null;
    }
}
