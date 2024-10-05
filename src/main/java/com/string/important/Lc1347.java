package com.string.important;

public class Lc1347 {

    public static void main(String[] args) {
        String s = "leetcode";
        String t = "practice";
        Lc1347 lc1347 = new Lc1347();
        int count = lc1347.minSteps(s,t);
        System.out.println(count);
    }

    public int minSteps(String s, String t) {
      int count1 = 0;
      if(s==null || t==null){
          return -1;
      }
      int arr1[] = new int[26];
      int arr2[] = new int[26];

      for(int i=0;i<s.length();i++){
          arr1[s.charAt(i)-'a']++;
          arr2[t.charAt(i)-'a']++;
      }

      for(int i=0; i<arr1.length;i++){
         if(arr1[i]>arr2[i]){
             count1 += arr1[i]-arr2[i];
         }
      }
      return count1;
    }
}
