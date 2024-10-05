package com.greedy;

import java.util.Arrays;

public class LC135Candy {

    public static void main(String[] args) {
      int[] ratings = {1,2,2};
      int candies = candy(ratings);
      System.out.println(candies);
    }

    public static  int candy(int[] ratings) {
       int n = ratings.length;
       int[] left = new int[ratings.length];
       int[] right = new int[ratings.length];
       int totalCandies = 0;
        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }
        }

        for(int i=0;i<ratings.length;i++){
            totalCandies+= Integer.max(left[i],right[i]);
        }

        return totalCandies;
    }
}
