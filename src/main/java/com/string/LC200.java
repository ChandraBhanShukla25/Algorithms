package com.string;

public class LC200 {

    public static void main(String[] args) {
        String word = "xyxzxe";
        char ch = 'z';
        LC200 lc200 = new LC200();
        System.out.println(lc200.reversePrefix(word,ch));
    }

    public String reversePrefix(String word, char ch) {
        int index=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                index=i;
                break;
            }
        }

        if(index!=0) {
            StringBuilder sb1 = new StringBuilder(word.substring(0, index+1));
            sb1.reverse();
            StringBuilder sb2 = new StringBuilder(word.substring(index+1, word.length()));
            return sb1.append(sb2).toString();
        }else{
            return word;
        }

    }
}
