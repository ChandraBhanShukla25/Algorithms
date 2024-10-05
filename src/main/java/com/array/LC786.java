package com.array;

import com.sun.source.tree.Tree;

import java.util.*;

public class LC786 {

    public static void main(String[] args) {
      LC786 lc786 = new LC786();
      int[] arr = {1,2,3,5}; int k = 3;
      int [] res = lc786.kthSmallestPrimeFraction(arr,k);
        System.out.println(res[0] + "--"+res[1]);

    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double, int[]> treeMap = new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>=0;j--){
                if(arr[i]!=arr[j]) {
                    double currentLow = (double) arr[i] / arr[j];
                    int[] currentArr = {arr[i],arr[j]};
                    treeMap.put(currentLow, currentArr);
                }
            }
        }
        Set<Double> set = treeMap.keySet();
        List<Double> resList = new ArrayList(set);
        double val = resList.get(k-1);
        return treeMap.get(val);
    }
}
