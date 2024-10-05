package com.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraywithSumK {

    public static void main(String[] args) {
       int N = 3;
       int k = 1;
       int array[] = {-1, 1, 1};
       int x= getLongestSubArray(N,k,array);
       // System.out.println(x);
        int r = 2; int arr[] = {1,2,3,4,5,6,7};
        leftRotate(arr, r);
        int[] a1 = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        int sum = maxSubarraySum(a1);
        System.out.println(sum);
    }

    private static void leftRotate(int[] arr, int r) {
        int j = r-1;
        int i=0;
        while(i<=j){
            swap(arr,i,j);
            i++;
            j--;
        }
        i=r;
        j=arr.length-1;
        while(i<=j){
            swap(arr,i,j);
            i++;
            j--;
        }

        i=0;
        j=arr.length-1;
        while(i<=j){
            swap(arr,i,j);
            i++;
            j--;
        }

        for(int x=0;x<arr.length;x++){
          //  System.out.println(arr[x]);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static int getLongestSubArray(int N, int K, int[] arr){
        int maxLength=-1;
        int sum = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        for(int i=0;i<N;i++){
            sum+=arr[i];
            if(sum==K){
               maxLength= Integer.max(maxLength,i+1);
            }
            int rem = sum-K;
            if(preSumMap.containsKey(rem)){
                maxLength = Integer.max(maxLength, i-preSumMap.get(rem));
            }
            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }

    public static int maxSubarraySum(int[] arr) {
        // write your code here
        int maxSofar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for(int i=0;i<arr.length;i++){
            maxEndingHere+=arr[i];
            maxSofar = Integer.max(maxSofar,maxEndingHere);
            if(maxEndingHere<0){
                maxEndingHere= 0;
            }


        }
        return maxSofar;
    }

}
