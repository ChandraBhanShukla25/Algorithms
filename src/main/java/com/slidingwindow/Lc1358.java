package com.slidingwindow;

import java.util.*;

public class Lc1358 {


    public static void main(String[] args) {
        String s= "abcabc";
        Lc1358 lc1358 = new Lc1358();
        int x =lc1358.numberOfSubstrings(s);
        System.out.println(x);

    }

    public int numberOfSubstrings(String s) {
        int[] val = new int[3];
        Arrays.fill(val, 0);
        int count = 0;
        int high =0;
        int low=0;
        int n = s.length();
        int res=0;
        while(high<n){
            val[s.charAt(high)-'a']++;
            while(val[0]>0 && val[1]>0 && val[2]>0){
                count++;
                val[s.charAt(low)-'a']--;
                low++;
            }
            res= res+count;
            high++;
        }
        return res;
    }
}
