package com.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithKSum {

    public static void main(String[] args) {
       int[] arr = {17, 15,
               -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
       int k = 15;
       int len = lenOfLongSubarr(arr, arr.length, k);
        System.out.println(len);
    }

    public static int lenOfLongSubarrUsingHashMap (int arr[], int n, int k) {

        Map<Integer, Integer> map = new HashMap<>();
         int i =0;
         int sum = 0;
         int maxLength = 0;
         int length = 0;
        while(i<n){
            sum = sum+arr[i];

            if(sum==k){
                maxLength = Integer.max(maxLength,i+1);
            }
            int remaining = sum-k;

            if(map.containsKey(remaining)){
                length = i- map.get(remaining);
                maxLength = Integer.max(maxLength,length);
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            i++;
        }

        return maxLength;
    }

    public static int lenOfLongSubarr (int arr[], int n, int k) {

        int i=0;
        int j=0;
        int sum = 0;
        int maxLength = 0;

        while(i<n){
            while(sum>k && j<=i){
               sum -= arr[j];
               j++;
            }

            if(sum==k){
                maxLength = Integer.max(i-j,maxLength);
            }
            sum = sum+arr[i];
            i++;
        }
        return maxLength;
    }


}
