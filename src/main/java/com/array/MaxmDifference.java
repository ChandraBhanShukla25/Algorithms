package com.array;

public class MaxmDifference {

    public static void main(String[] args) {
        int arr[] = {2,3,10,2,4,8,1};

        int maxDiff = maxDiff(arr);
        System.out.println(maxDiff);
    }

    private static int maxDiff(int[] arr) {


        int j = 0;
        int i =j+1;
        int maxDiff = Integer.MIN_VALUE;


        while(i<arr.length-1){

            if(arr[i]<arr[i+1]){
                i++;
                maxDiff = Integer.max(maxDiff, arr[i]-arr[j]);
            }else{
                j=i;
            }
            i++;

        }
        return maxDiff;
    }
}
