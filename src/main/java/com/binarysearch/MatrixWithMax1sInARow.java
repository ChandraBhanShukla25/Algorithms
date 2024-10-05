package com.binarysearch;

public class MatrixWithMax1sInARow {

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}};
        int n = arr.length;
        int m = arr[0].length;

        MatrixWithMax1sInARow matrix = new MatrixWithMax1sInARow();
        int count = matrix.rowWithMax1s(arr, n, m);
        System.out.println(count);
    }

    int rowWithMax1s(int arr[][], int n, int m) {
        int maxCount = 0;
        int index = -1;
        for(int i=0;i<n;i++){
            int count1s = m- lowerBound(arr[i], m);
            if(count1s>maxCount){
                maxCount= count1s;
                index=i;
            }
        }
        return index;
    }

    private int lowerBound(int[] arr, int m) {

        int high = m-1;
        int low = 0;
        int ans = m;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=1){
                ans = mid;
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
