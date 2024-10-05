package com.revision.string;

public class LC10 {

    public static  String reverseWords(String s) {
        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0;i--){
            sb.append(arr[i]);
            if(sb.charAt(sb.length()-1)!=' '){
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "a good   example";
        String res = reverseWords(str);
        System.out.println(res);
    }
}
