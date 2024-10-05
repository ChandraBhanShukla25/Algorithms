package com.recursion;

import java.util.Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Arrays.stream(arr).forEach(System.out::println);
        int i=0;
        reverse(arr, i, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
        reverse1(arr, i);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void reverse(int[] arr, int i, int n) {
        if(i>=n){
            return;
        }
        int temp = arr[i];
        arr[i]=arr[n];
        arr[n]=temp;
        reverse(arr,i+1,n-1);
    }

    private static void reverse1(int[] arr, int i) {
        if(i>=arr.length-1-i){
            return;
        }
        int temp = arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i]=temp;
        reverse1(arr,i+1);
    }
}
