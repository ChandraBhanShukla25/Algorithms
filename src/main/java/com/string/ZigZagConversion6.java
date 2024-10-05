package com.string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion6 {

    public static void main(String[] args) {
        String  s = "PAYPALISHIRING";
        int numRows = 3;
        ZigZagConversion6 zigzag = new ZigZagConversion6();
        String str  = zigzag.convert(s, numRows);
        System.out.println(str);
    }

    public String convert(String s, int numRows) {
      StringBuilder sb = new StringBuilder();
      List<StringBuilder>  lst = new ArrayList<>(numRows);
      boolean goDown = true;

      if(numRows==1 || numRows>=s.length())
          return s;
      for(int i=0;i<numRows;i++){
          lst.add(new StringBuilder());
      }

      int height = 0;
      boolean travelDown = false;
      for(int i=0;i<s.length();i++){
          if(height==0 || height==numRows-1)
              travelDown=!travelDown;
          lst.get(height).append(s.charAt(i));
          height+=travelDown?1:-1;
      }

      StringBuilder solution = new StringBuilder();
      for(StringBuilder res : lst){
          solution.append(res);
      }
      return solution.toString();
    }
}

//https://medium.com/@ChrisBader/code-conquer-leetcode-6-zigzag-conversion-5b4246b6117c