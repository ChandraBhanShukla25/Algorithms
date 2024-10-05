package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring78 {

    public static void main(String[] args) {
       String s = "ADOBECODEBANC";
       String t = "ABC";
       MinimumWindowSubstring78 minimumWindowSubstring78 = new MinimumWindowSubstring78();
       String minStr = minimumWindowSubstring78.minWindow(s,t);
       System.out.println(minStr);
    }

    public String minWindow(String s, String t) {
      int[] charFrequencyInTarget = new int[128];
      int[] charFrequencyInSource = new int[128];

      int sourceLength = s.length();
      int targetLength = t.length();

      for(int i=0;i<targetLength;i++){
          charFrequencyInTarget[t.charAt(i)]++;
      }

      int matchCount = 0;
      int minWindow = -1;
      int low = 0;
      int start = -1;
      int minLength = Integer.MAX_VALUE;

      for(int high =0;high<sourceLength;high++){
          charFrequencyInSource[s.charAt(high)]++;

          if(charFrequencyInTarget[s.charAt(high)] >= charFrequencyInSource[s.charAt(high)]){
             matchCount++;
          }

          while(matchCount==targetLength){

              int windowLength = high - low+1;

              if(windowLength<minLength){
                  minLength = windowLength;
                  start = low;
              }

              char charAtStart = s.charAt(start);
              if(charFrequencyInTarget[charAtStart] >= charFrequencyInSource[charAtStart]){
                  matchCount--;
              }
              charFrequencyInSource[charAtStart]--;
              low++;
          }
      }

      return  start<0 ? "" : s.substring(start, start+minLength);
    }
}
