package com.slidingwindow;

public class LengthOfLongestWord58 {

    public static void main(String[] args) {
       String s= "   fly me   to   the moon  ";
       String s1 = "luffy is still joyboy";
       int max = new LengthOfLongestWord58().lengthOfLastWord(s);
        int max1 = new LengthOfLongestWord58().lengthOfLastWord(s1);
        System.out.println(max);
        System.out.println(max1);
    }

    public int lengthOfLastWord(String s) {
        int i=0;
        int j=0;
        int length = 0;
        if(s.length()==0){
            return 0;
        }
        while(i<s.length()){
           if(s.charAt(i)==' '){
               j=i;
           }
           length=i-j+1;
           i++;
        }
        return length;
    }
}
