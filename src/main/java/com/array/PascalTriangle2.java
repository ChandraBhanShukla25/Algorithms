package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {

    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        List<Integer> result = pascalTriangle2.getRow(5);
        System.out.println(result);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> previous = new ArrayList<>();
        previous.add(1);
      for(int i=0; i<rowIndex; i++){
          for(int j=i;j>0;j--){
             previous.set(j, previous.get(j)+previous.get(j-1));
          }
          previous.add(1);
      }
      return previous;
    }
}

// 1
//