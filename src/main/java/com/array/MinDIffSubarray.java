package com.array;

import java.util.ArrayList;
import java.util.List;

public class MinDIffSubarray {

    public static void main(String[] args) {
       int arr[] = {7, 9, 5, 10};
       List<Integer> l1 = new ArrayList<>();
       List<Integer> l2 = new ArrayList<>();
       minDiffList(l1,l2, arr);
    }

    private static void minDiffList(List<Integer> l1, List<Integer> l2, int[] arr) {
        int totalSum = 0;
        int minDiff = Integer.MAX_VALUE;
        int prefixSum = 0;

        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }

        for(int i=0;i<arr.length;i++){
            if(prefixSum+arr[i]> Math.abs(totalSum-prefixSum-arr[i]- prefixSum-arr[i])){
                l1.add(arr[i]);
                prefixSum=prefixSum+arr[i];
            }else{
                l2.add(arr[i]);
            }
        }

        System.out.println(l1);
        System.out.println(l2);
    }
}
