package com.dynamicprogramming;

public class LC1547MinimumCostToCutAStick {

    public static void main(String[] args) {
       int n =9;
       int[] cuts = {5,6,1,4,2};

       LC1547MinimumCostToCutAStick minimumCostToCutAStick = new LC1547MinimumCostToCutAStick();
       int x =  minimumCostToCutAStick.minCost(n, cuts);
        System.out.println(x);
    }

    public int minCost(int n, int[] cuts) {

        int size = cuts.length;
      return size;

    }
}
