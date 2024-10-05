package com.string.important;

public class LC38CountAndSay {

    public static void main(String[] args) {
       int n = 4;
       LC38CountAndSay countAndSay = new LC38CountAndSay();
       String str = countAndSay.countAndSay(n);
        System.out.println(str);
    }

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str = countAndSay(n-1);
        String result = "";
        int i=0;
        int len = str.length();
        while(i<len){
            char lastChar = str.charAt(i);
            int count =0;
            while(i<len && str.charAt(i)==lastChar){
                count++;
                i++;
            }
            result+=count;
            result+=lastChar;
        }
        return result;
    }
}
