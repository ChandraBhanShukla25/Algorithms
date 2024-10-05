package com.binarysearch;

import java.util.Arrays;

public class BookAllocation {

    public static void main(String[] args) {
       int  n = 5;
       int  m = 4;
       int[] arr = {25, 46, 28, 49, 24};
       BookAllocation bookAllocation = new BookAllocation();
       int x = bookAllocation.findPages(arr, n, m);
        int xBinary = bookAllocation.findPagesUsingBinarySearch(arr, n, m);
        System.out.println(x);
        System.out.println(xBinary);
    }

    public  int findPages(int[] arr, int n, int m){
        if(arr.length<m){
            return 0;
        }
       int low = Arrays.stream(arr).max().getAsInt();
       int high = Arrays.stream(arr).sum();

       for(int i=low;i<=high;i++){
           int students = possibleToDistribute(arr, i, m);
           if(students==m){
              return i;
           }
       }
       return 0;
    }

    public  int findPagesUsingBinarySearch(int[] arr, int n, int m){
        if(arr.length<m){
            return 0;
        }
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while(low<=high){
            int mid = (low+high)/2;
            if(possibleToDistribute(arr, mid, m)==m){
                return mid;
            }
            if(possibleToDistribute(arr, mid, m)<m){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return 0;
    }

    private int possibleToDistribute(int[] arr, int pageCount, int m) {
        int n = arr.length;
        int pages = 0;
        int student = 1;
        for(int i=0;i<n;i++){
            if(pages+arr[i]<=pageCount){
                pages= pages+arr[i];
            }else{
                student++;
                pages = arr[i];
            }
        }

        return student;
    }
}
