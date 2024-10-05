package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC506RelativeBanks {

    public static void main(String[] args) {
        int [] scores = {10,3,8,9,4};
        LC506RelativeBanks lc506RelativeBanks = new LC506RelativeBanks();
        String[] res = lc506RelativeBanks.findRelativeRanks(scores);
        Arrays.stream(res).forEach(System.out::println);
    }

    public String[] findRelativeRanks(int[] score) {
      List<Integer> list = new ArrayList<>();
      for(int i:score){
          list.add(i);
      }
      Collections.sort(list, (i1,i2)->i2-i1);

      String[] str = new String[score.length];
      int i=0;
      for(int points: score){
          int index = list.indexOf(points);
         // System.out.println(index);
          if(index ==0){
              str[i]="Gold Medal";
          } else if(index==1){
              str[i]="Silver Medal";
          } else if(index==2){
              str[i]="Bronze Medal";
          } else{
              str[i]=String.valueOf(index+1);
          }
          i++;
      }
      return str;
    }
}
