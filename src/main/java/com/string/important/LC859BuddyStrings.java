package com.string.important;

public class LC859BuddyStrings {

    public static void main(String[] args) {
       String  s = "ab";
       String  goal  = "ba";
       LC859BuddyStrings buddyStrings = new LC859BuddyStrings();
       boolean isBudyy = buddyStrings.buddyStrings(s,goal);
        System.out.println(isBudyy);
    }
    public boolean buddyStrings(String s, String goal) {
        if(s==null || goal==null || s.length()!=goal.length())
            return false;

        int[] countArr1 = new int[26];
        int[] countArr2 = new int[26];

        int difference = 0;
        for(int i=0;i<s.length();i++){
            countArr1[s.charAt(i)-'a']++;
            countArr2[goal.charAt(i)-'a']++;
            if(s.charAt(i)!=goal.charAt(i)){
                difference++;
            }
        }
        boolean duplicateFound = false;
        for(int i=0;i<countArr2.length;i++){
            if(countArr2[i]!=countArr1[i]){
                return false;
            }
            if(countArr2[i]>1){
                duplicateFound=true;
            }
        }
        return difference==2 || (difference==0 && duplicateFound) ;
    }
}
