package com.array;

public class LC941 {

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        boolean isValid = validMountainArray(arr);
        System.out.println(isValid);
    }

    public  static boolean validMountainArray(int[] arr) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        if(arr==null || arr.length<3 || arr[0]>=arr[1]){
            return false;
        }
        int decreasingIndex = -1;
        int i=1;
        for( i=1;i<arr.length;i++){
           if(arr[i-1]>=arr[i]){
               decreasingIndex=i;
               break;
           }
        }
        if(i==arr.length)
            return false;

        for( i=decreasingIndex;i<arr.length;i++){
            if(arr[i-1]<arr[i]){
                return false;
            }
        }
        return true;
    }
}
