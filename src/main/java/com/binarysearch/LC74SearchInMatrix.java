package com.binarysearch;

public class LC74SearchInMatrix {

    public static void main(String[] args) {
        LC74SearchInMatrix searchInMatrix = new LC74SearchInMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean isFound = searchInMatrix.searchMatrix(matrix, target);
        System.out.println( isFound);
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i=0;i<matrix.length;i++){
            if(search(matrix[i], target)){
                return true;
            }
        }
        return false;
    }


    private boolean search(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
