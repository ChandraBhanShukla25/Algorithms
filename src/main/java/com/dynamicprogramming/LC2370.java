package com.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC2370 {

    public static void main(String[] args) {
        String s = "pvjcci";
        int k = 4;
        LC2370 lc = new LC2370();
        int sequnece = lc.longestIdealString(s,k);
        System.out.println(sequnece);
    }

    // acfg
    public int longestIdealString(String s, int k) {
      int dp[] = new int[s.length()];
      Arrays.fill(dp,1);
      Map<Character, Integer> map = new HashMap<>(26);
      map.put(s.charAt(0),0);
      int max = 1;
      for(int i=1;i<s.length();i++){
          char ch = s.charAt(i);
          for(char prev='a';prev<='z';prev++){
            if(Math.abs(ch-prev)>k) {
                continue;
            }
            if(map.containsKey(prev)){
                dp[i]=Math.max(dp[i],dp[map.get(prev)]+1);
            }

          }
          map.put(ch, i);
          max = Integer.max(max, dp[i]);
      }


      return max;
    }


    /*
     int lengthOfString = s.length(); // The length of the string s.
        int longestLength = 1; // Initialize the answer to 1 character as the minimum length of ideal string.
        int[] dynamicProgramming = new int[lengthOfString]; // Array to store the length of the longest ideal substring ending at each character.
        Arrays.fill(dynamicProgramming, 1); // At minimum, each character itself is an ideal string.

        // HashMap to keep track of the last index of each character that is part of the longest ideal string so far.
        Map<Character, Integer> lastSeenCharacterMap = new HashMap<>(26);

        // Place the first character in the map to start the process.
        lastSeenCharacterMap.put(s.charAt(0), 0);

        // Iterate through each character in the string starting from the second character.
        for (int i = 1; i < lengthOfString; ++i) {
            char currentChar = s.charAt(i); // The current character for which we are finding the ideal string.

            // Check closeness of every character in the alphabet to the current character within the limit k.
            for (char prevChar = 'a'; prevChar <= 'z'; ++prevChar) {
                // If the absolute difference in ASCII value is within the limit k, we proceed.
                if (Math.abs(currentChar - prevChar) > k) {
                    continue;
                }
                // If the previous character has been seen and is part of an ideal string,
                // we update the DP table by taking the max of the current dp value or
                // the dp value of the previous character's last index plus one.
                if (lastSeenCharacterMap.containsKey(prevChar)) {
                    dynamicProgramming[i] = Math.max(dynamicProgramming[i], dynamicProgramming[lastSeenCharacterMap.get(prevChar)] + 1);
                }
            }

            // Update the last seen index of the current character to be the current index.
            lastSeenCharacterMap.put(currentChar, i);
            // Update longestLength to be the maximum of itself and the current length of the longest ideal string ending at i.
            longestLength = Math.max(longestLength, dynamicProgramming[i]);
        }

        // Return the length of the longest ideal string that can be formed from the input string.
        return longestLength;
     */

//    public int longestIdealString1(String s, int k) {
//        int x=0;
//        for(int i=0;i<s.length()-1;i++){
//            int j=i+1;
//            if(((s.charAt(i)+'0') - (s.charAt(j)+'0')) <=k ){
//                x=x+1;
//            }
//        }
//        return x;
//    }


}
