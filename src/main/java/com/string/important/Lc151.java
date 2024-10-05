package com.string.important;

public class Lc151 {

    public static void main(String[] args) {
        String str =  "  a good   example  ";
        Lc151 lc = new Lc151();
        String s= lc.reverseWords(str);
        System.out.println( s);
    }

    public String reverseWords(String s) {
     s.trim();
     String[] lst = s.split(" ");
     StringBuilder sb = new StringBuilder();
     for(int i=lst.length-1;i>=0;i--){
         sb.append(lst[i]);
         if(sb.charAt(sb.length()-1)!=' ')
         sb.append(" ");
     }


     return sb.toString().trim();
    }
}
