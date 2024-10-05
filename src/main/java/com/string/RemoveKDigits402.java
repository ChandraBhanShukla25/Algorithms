package com.string;

public class RemoveKDigits402 {


    public static void main(String[] args) {
        RemoveKDigits402 removeKDigits402 = new RemoveKDigits402();
        String num = "10200"; int k = 1;
        String s = removeKDigits402.removeKdigits(num,k);
        System.out.println(s);
    }
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch: num.toCharArray()){
            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)>ch){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(ch);
        }

        while(k>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        System.out.println(sb.toString());
        int i=0;
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
