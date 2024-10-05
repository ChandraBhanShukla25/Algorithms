package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LC455AssignCookies {

    public static void main(String[] args) {
        int[] g = {10,9,8,7}; int[] s = {5,6,7,8};
        int[] g1 = Arrays.stream(g).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int[] s1 = Arrays.stream(s).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        LC455AssignCookies assignCookies = new LC455AssignCookies();
        int x = assignCookies.findContentChildren(g1,s1);
        System.out.println(x);
    }

    public int findContentChildren(int[] g, int[] s) {
        int[] g1 = Arrays.stream(g).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int[] s1 = Arrays.stream(s).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int i=0;
        int j=0;
        int count=0;
      while(i<g1.length){
          if(j==s1.length)
              return count;
           if(g1[i]<=s1[j]){
               count++;
               j++;
           }
           i++;
      }
      return count;
    }
}
