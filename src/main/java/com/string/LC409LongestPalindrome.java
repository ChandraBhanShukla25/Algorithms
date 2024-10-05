package com.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LC409LongestPalindrome {

    public static void main(String[] args) {
      String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
      LC409LongestPalindrome longestPalindrome = new LC409LongestPalindrome();
      int x =  longestPalindrome.longestPalindrome(s);
        System.out.println(x);
    }

    public int longestPalindrome(String s) {
        if(s==null || s.isEmpty())
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
              map.put(ch, map.getOrDefault(ch, 0) + 1);
          }
      int count = 0;
      boolean foundOdd = false;
      for(int  x : map.values()){
          if(x%2==0){
              count+=x;
          }else {
              foundOdd = true;
              count+= x-1;
          }
      }
      if(foundOdd){
          count=count+1;
      }
      return count;
    }


}
