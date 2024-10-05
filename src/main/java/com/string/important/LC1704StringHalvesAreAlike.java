package com.string.important;

public class LC1704StringHalvesAreAlike {

    public static void main(String[] args) {
       String str = "book";
       LC1704StringHalvesAreAlike stringhalves = new LC1704StringHalvesAreAlike();
       boolean isAlike = stringhalves.halvesAreAlike(str);
       System.out.println(isAlike);

    }

    public boolean halvesAreAlike(String s) {
        if(s.isEmpty()){
            return false;
        }
       int start = 0;
       int mid = s.length()/2;
       int end = s.length();
       int vowelsOnLeft = 0;
       int vowelsOnRight = 0;
       while(start<mid){
           if(isVowel(s.charAt(start))){
               vowelsOnLeft++;
           }
           start++;
       }
        while(mid<end){
            if(isVowel(s.charAt(mid))){
                vowelsOnRight++;
            }
            mid++;
        }
       return vowelsOnRight==vowelsOnLeft;
    }

    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U';
    }
}
