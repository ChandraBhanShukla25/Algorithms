package com.array.important;

public class ArrayNegativeMarking {


    public static void main(String args[]) {
        int arr[] = {5,4,5,3,4,2};
        new ArrayNegativeMarking().getDuplicates(arr);
    }

     int getDuplicates(int[] arr) {
        int n = arr.length;
         for (int i : arr) {
             if (arr[Math.abs(i) - 1] < 0) {
                 System.out.println(arr[i]);
             }
             arr[Math.abs(i) - 1] *= -1;
         }

         return 0;
    }
}
