package com.binarysearch;

public class LC240SearchInSortedMatrix {

    public static void main(String[] args) {
      int[][] matrix = {{1,1}};
      int target = 2;
      LC240SearchInSortedMatrix searchInSortedMatrix = new LC240SearchInSortedMatrix();
      boolean found = searchInSortedMatrix.searchMatrix(matrix, target);
        System.out.println(found);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = matrix[0].length-1;

        while(row<m && col>=0){
            if(target==matrix[row][col]){
                return true;
            }
            if(target<matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
