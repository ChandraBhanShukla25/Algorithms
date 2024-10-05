package com.string;

public class LC2486AppendCharacters {

    public static void main(String[] args) {
        String s = "coaching";
        String t = "coding";
        LC2486AppendCharacters lc2486 = new LC2486AppendCharacters();
        int x = lc2486.appendCharacters(s,t);
        System.out.println(x);
    }

    public int appendCharacters(String s, String t) {

        int i=0;
        for(char ch: s.toCharArray()){
            if(ch==t.charAt(i)){
                ++i;
                if(i==t.length()){
                    return 0;
                }
            }
        }
        return t.length()-i;
    }
}
